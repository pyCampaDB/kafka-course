package com.pycampadb.kafka.broker.stream;

import com.pycampadb.avro.data.Hello;
import com.pycampadb.kafka.broker.message.HelloPositiveUppercase;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

//@Component
public class HelloStream {
    @Autowired
    void kStreamAvroHello(StreamsBuilder builder,@Autowired @Qualifier("serdeConfig")Map<String, String> serdeConfig){
        var helloSerde = new SpecificAvroSerde<Hello>();

        helloSerde.configure(serdeConfig, false);

        builder.stream("sc-hello", Consumed.with(Serdes.String(), helloSerde))
                .mapValues(this::mapHello).print(Printed.toSysOut());
    }

    private HelloPositiveUppercase mapHello(Hello original){
        var result = new HelloPositiveUppercase();
        result.setPositiveInt(Math.abs(original.getMyIntField()));
        result.setUppercaseString(original.getMyStringField().toUpperCase());

        return  result;
    }
}
