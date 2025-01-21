package com.pycampadb.msvc.broker.stream.commodity.impl;

import com.pycampadb.msvc.broker.message.OrderMessage;
import com.pycampadb.msvc.broker.stream.commodity.MaskOrderStream;
import com.pycampadb.msvc.util.CommodityStreamUtil;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Component to CommodityOneStreamImpl
public class MaskOrderStreamImpl implements MaskOrderStream {
    @Override
    @Autowired
    public void kStreamCommodityMask(StreamsBuilder builder) {
        var orderSerde = new JsonSerde<>(OrderMessage.class);
        var maskedCreditCardStream = builder.stream(
                "t-commodity-order",
                Consumed.with(Serdes.String(), orderSerde))
                .mapValues(CommodityStreamUtil::maskCreditCardNumber);
        maskedCreditCardStream.to(
                "t-commodity-order-masked",
                Produced.with(Serdes.String(), orderSerde)
        );

        maskedCreditCardStream.print(Printed.<String, OrderMessage>toSysOut().withLabel("Masked Order Sream"));
    }
}
