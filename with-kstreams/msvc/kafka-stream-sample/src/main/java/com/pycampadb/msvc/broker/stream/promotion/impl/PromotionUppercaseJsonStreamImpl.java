package com.pycampadb.msvc.broker.stream.promotion.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pycampadb.msvc.broker.message.PromotionMessage;
import com.pycampadb.msvc.broker.stream.promotion.PromotionUppercaseJsonStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Printed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//@Component pasamos ahora a PromotionUppercaseSpringJsonStream
public class PromotionUppercaseJsonStreamImpl implements PromotionUppercaseJsonStream {
    private static final Logger log = LoggerFactory.getLogger(PromotionUppercaseJsonStreamImpl.class);
    private final ObjectMapper mapper;

    public PromotionUppercaseJsonStreamImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @Autowired
    public void kstreamPromotionUppercase(StreamsBuilder builder) {
        var sourceStream = builder.stream(
                "t-commodity-promotion",
                Consumed.with(Serdes.String(), Serdes.String())
        );
        var uppercaseStream = sourceStream.mapValues(this::uppercasePromotionCode);
        uppercaseStream.to("t-commodity-promotion-uppercase");
        sourceStream.print(Printed.<String, String>toSysOut().withLabel("JSON Original Stream"));
        uppercaseStream.print(Printed.<String, String>toSysOut().withLabel("JSON Uppercase Stream"));
    }

    private String uppercasePromotionCode(String jsonString) {
        try{
            var promotion = mapper.readValue(jsonString, PromotionMessage.class);
            promotion.setPromotionCode(promotion.getPromotionCode().toUpperCase());
            return mapper.writeValueAsString(promotion);
        } catch (JsonProcessingException e){
            log.warn("Unable to proccess JSON", e);
            return "";
        }
    }
}
