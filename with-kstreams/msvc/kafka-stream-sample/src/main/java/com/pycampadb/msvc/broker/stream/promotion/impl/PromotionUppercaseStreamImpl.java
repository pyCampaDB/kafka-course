package com.pycampadb.msvc.broker.stream.promotion.impl;

import com.pycampadb.msvc.broker.stream.promotion.PromotionUppercaseStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;

//@Configuration funcionan igual esta y la clase PromotionUppercaseStream2Impl,
//escritas de distinta forma. Ambas son válidas
//en este caso devolvemos un valor, en el caso de hacerlo con @Component, el método es void
public class PromotionUppercaseStreamImpl implements PromotionUppercaseStream {

    @Override
    //@Bean
    public KStream<String, String> kstreamPromotionUppercase(StreamsBuilder builder){
        KStream<String, String> sourceStream = builder.stream(
                "t-commodity-promotion",
                Consumed.with(Serdes.String(), Serdes.String())
        );

        var uppercaseStream = sourceStream.mapValues(promotion -> promotion.toUpperCase());

        uppercaseStream.to("t-commodity-promotion-uppercase");

        //useful for debugging, but it is better not to use this on production
        sourceStream.print(Printed.<String, String>toSysOut().withLabel("Original Stream"));
        uppercaseStream.print(Printed.<String, String>toSysOut().withLabel("Uppercase Stream"));

        return sourceStream;
    }
}
