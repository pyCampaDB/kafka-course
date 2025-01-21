package com.pycampadb.msvc.broker.stream.promotion.impl;

import com.pycampadb.msvc.broker.stream.promotion.PromotionUppercase2Stream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.beans.factory.annotation.Autowired;

//@Component vamos a uitlizar ahora PromotionUppercaseJsonStream
public class PromotionUppercaseStream2Impl implements PromotionUppercase2Stream {

    @Override
    @Autowired
    public void kstreamPromotionUppercase(StreamsBuilder builder){
        KStream<String, String> sourceStream = builder.stream(
                "t-commodity-promotion",
                Consumed.with(Serdes.String(), Serdes.String())
        );

        var uppercaseStream = sourceStream.mapValues(promotion -> promotion.toUpperCase());

        uppercaseStream.to("t-commodity-promotion-uppercase");

        //useful for debugging, but it is better not to use this on production
        sourceStream.print(Printed.<String, String>toSysOut().withLabel("Original Stream"));
        uppercaseStream.print(Printed.<String, String>toSysOut().withLabel("Uppercase Stream"));
    }
}
