package com.pycampadb.msvc.broker.stream.commodity.impl;

import com.pycampadb.msvc.broker.message.OrderMessage;
import com.pycampadb.msvc.broker.message.OrderPatternMessage;
import com.pycampadb.msvc.broker.message.OrderRewardMessage;
import com.pycampadb.msvc.broker.stream.commodity.CommodityStream;
import com.pycampadb.msvc.util.CommodityStreamUtil;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Branched;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;


//@Component
public class CommodityFiveStreamImpl implements CommodityStream {

    private static final Logger log = LoggerFactory.getLogger(CommodityFiveStreamImpl.class);

    private void reportFraud(OrderMessage message){
        log.info("Reporting fraud: {}", message);
    }

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
                                        ks.to("t-commodity-pattern-five-plastic", Produced.with(Serdes.String(), orderPatternSerde)
                                )
                        )
                ).defaultBranch(Branched.<String, OrderPatternMessage>withConsumer(
                        ks ->
                                ks.to("t-commodity-pattern-five-notplastic", Produced.with(Serdes.String(), orderPatternSerde))
                ));


        maskedCreditCardStream.filter(CommodityStreamUtil.isLargeQuantity())
                .filterNot(CommodityStreamUtil.isCheap())
                .map(CommodityStreamUtil.mapToOrderRewardChangeKey())
                .to("t-commodity-reward-five", Produced.with(Serdes.String(), orderRewardSerde));

        maskedCreditCardStream
                .selectKey(CommodityStreamUtil.generateStorageKey())
                .to("t-commodity-storage-five", Produced.with(Serdes.String(), orderSerde));

        maskedCreditCardStream.filter(
                (k,v) -> v.getOrderLocation().toUpperCase().startsWith("C"))
                        .peek((k,v) -> reportFraud(v))
                        .map((k,v)
                                -> KeyValue.pair(
                                        v.getOrderLocation().toUpperCase().charAt(0) + "***",
                                        (long) v.getPrice() * v.getQuantity()
                                ))
                        .to("t-commodity-fraud-five", Produced.with(Serdes.String(), Serdes.Long()));
    }
}
