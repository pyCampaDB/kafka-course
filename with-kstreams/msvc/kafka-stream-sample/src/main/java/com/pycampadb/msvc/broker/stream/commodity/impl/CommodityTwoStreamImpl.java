package com.pycampadb.msvc.broker.stream.commodity.impl;

import com.pycampadb.msvc.broker.message.OrderMessage;
import com.pycampadb.msvc.broker.message.OrderPatternMessage;
import com.pycampadb.msvc.broker.message.OrderRewardMessage;
import com.pycampadb.msvc.broker.stream.commodity.CommodityStream;
import com.pycampadb.msvc.util.commodity.CommodityStreamUtil;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Branched;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Component to CommodityThreeStream
public class CommodityTwoStreamImpl implements CommodityStream {
    @Override
    @Autowired
    public void kStreamCommodityTrading(StreamsBuilder builder) {
        var orderSerde = new JsonSerde<>(OrderMessage.class);
        var orderPatternSerde = new JsonSerde<>(OrderPatternMessage.class);
        var orderRewardSerde = new JsonSerde<>(OrderRewardMessage.class);

        var maskedCreditCardStream = builder.stream("t-commodity-order", Consumed.with(Serdes.String(), orderSerde))
                .mapValues(CommodityStreamUtil::maskCreditCardNumber);

        maskedCreditCardStream.mapValues(CommodityStreamUtil::convertToPatternMessage)
                .split()
                .branch(CommodityStreamUtil.isPlasticItem(),
                        Branched.<String, OrderPatternMessage>withConsumer(ks ->
                                        ks.to("t-commodity-pattern-two-plastic", Produced.with(Serdes.String(), orderPatternSerde)
                                )
                        )
                ).defaultBranch(Branched.<String, OrderPatternMessage>withConsumer(
                        ks ->
                                ks.to("t-commodity-pattern-two-notplastic", Produced.with(Serdes.String(), orderPatternSerde))
                ));


        maskedCreditCardStream.filter(CommodityStreamUtil.isLargeQuantity())
                .filterNot(CommodityStreamUtil.isCheap())
                .mapValues(CommodityStreamUtil::convertToOrderRewardMessage)
                .to("t-commodity-reward-two", Produced.with(Serdes.String(), orderRewardSerde));

        maskedCreditCardStream
                .selectKey(CommodityStreamUtil.generateStorageKey())
                .to("t-commodity-storage-two", Produced.with(Serdes.String(), orderSerde));
    }
}
