package com.pycampadb.msvc.broker.stream.commodity.impl;

import com.pycampadb.msvc.broker.message.OrderMessage;
import com.pycampadb.msvc.broker.message.OrderPatternMessage;
import com.pycampadb.msvc.broker.message.OrderRewardMessage;
import com.pycampadb.msvc.broker.stream.commodity.CommodityStream;
import com.pycampadb.msvc.util.CommodityStreamUtil;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Component to CommodityTwoStream
public class CommodityOneStreamImpl implements CommodityStream {
    @Override
    @Autowired
    public void kStreamCommodityTrading(StreamsBuilder builder) {
        var orderSerde = new JsonSerde<>(OrderMessage.class);
        var orderPatternSerde = new JsonSerde<>(OrderPatternMessage.class);
        var orderRewardSerde = new JsonSerde<>(OrderRewardMessage.class);

        var maskedCreditCardStream = builder.stream("t-commodity-order", Consumed.with(Serdes.String(), orderSerde))
                .mapValues(CommodityStreamUtil::maskCreditCardNumber);

        maskedCreditCardStream.mapValues(CommodityStreamUtil::convertToPatternMessage)
                .to("t-commodity-pattern-one", Produced.with(Serdes.String(), orderPatternSerde));

        maskedCreditCardStream.filter(CommodityStreamUtil.isLargeQuantity())
                .mapValues(CommodityStreamUtil::convertToOrderRewardMessage)
                .to("t-commodity-reward-one", Produced.with(Serdes.String(), orderRewardSerde));

        maskedCreditCardStream.to("t-commodity-storage-one", Produced.with(Serdes.String(), orderSerde));
    }
}
