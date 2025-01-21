package com.pycampadb.msvc.broker.stream.promotion.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.msvc.broker.message.PromotionMessage;
import com.pycampadb.msvc.broker.serde.PromotionSerde;
import com.pycampadb.msvc.broker.stream.promotion.PromotionUppercaseCustomJsonStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class PromotionUppercaseCustomJsonStreamImpl implements PromotionUppercaseCustomJsonStream {
    private final ObjectMapper mapper;

    public PromotionUppercaseCustomJsonStreamImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @Autowired
    public void kStreamPromotionUppercase(StreamsBuilder builder) {
        var customJsonSerde = new PromotionSerde(mapper);
        var sourceStream = builder.stream(
                "t-commodity-promotion",
                Consumed.with(Serdes.String(), customJsonSerde)
        );

        var uppercaseStream = sourceStream.mapValues(this::uppercasePromotionCode);

        uppercaseStream.to(
                "t-commodity-promotion-uppercase",
                Produced.with(Serdes.String(), customJsonSerde)
        );

        sourceStream.print(Printed.<String, PromotionMessage>toSysOut().withLabel("Custom JSON Serde Original Stream"));
        uppercaseStream.print(Printed.<String, PromotionMessage>toSysOut().withLabel("Custom JSON Serde Uppercase Stream"));
    }

    private PromotionMessage uppercasePromotionCode(PromotionMessage message){
        return new PromotionMessage(message.getPromotionCode().toUpperCase());
    }
}
