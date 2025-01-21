package com.pycampadb.msvc.broker.stream.promotion.impl;

import com.pycampadb.msvc.broker.message.PromotionMessage;
import com.pycampadb.msvc.broker.stream.promotion.PromotionUppercaseSpringJsonStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;

//@Component
public class PromotionUppercaseSpringJsonStreamImpl implements PromotionUppercaseSpringJsonStream {

    @Override
    @Autowired
    public void kStreamPromotionUppercase(StreamsBuilder builder) {
        var jsonSerde = new JsonSerde<>(PromotionMessage.class);
        var sourceStream = builder.stream(
                "t-commodity-promotion",
                Consumed.with(Serdes.String(), jsonSerde)
        );

        var uppercaseStream = sourceStream.mapValues(this::uppercasePromotionCode);

        uppercaseStream.to(
                "t-commodity-promotion-uppercase",
                Produced.with(Serdes.String(), jsonSerde)
        );

        sourceStream.print(Printed.<String, PromotionMessage>toSysOut().withLabel("JSON Original Stream"));
        uppercaseStream.print(Printed.<String, PromotionMessage>toSysOut().withLabel("JSON Uppercase Stream"));
    }

    private PromotionMessage uppercasePromotionCode(PromotionMessage message){
        return new PromotionMessage(message.getPromotionCode().toUpperCase());
    }
}
