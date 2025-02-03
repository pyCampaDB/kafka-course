package com.pycampadb.ui.broker.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaUiDummyStream implements KafkaUiStream{
    private static final String TOPIC_ONE = "t-ui-demo-one";
    private static final String TOPIC_TWO = "t-ui-demo-two";
    private static final String TOPIC_ONE_UPPER_TARGET = "t-ui-demo-one-stream-uppercase-output";
    private static final String TOPIC_ONE_ONLY_OUTPUT = "t-ui-demo-one-stream-true-only-output";
    private static final String TOPIC_TWO_LOWER_TARGET = "t-ui-demo-two-stream-lowercase-output";


    @Override
    @Autowired
    public void kStreamDummy(StreamsBuilder builder) {
        var sourceStream = builder.stream(TOPIC_ONE, Consumed.with(Serdes.String(), Serdes.String()));

        sourceStream.mapValues(s -> s.toUpperCase())
                .to(TOPIC_ONE_UPPER_TARGET, Produced.with(Serdes.String(), Serdes.String()));

        sourceStream.filter((k, v) -> v.toLowerCase().contains("true"))
                .to(TOPIC_ONE_ONLY_OUTPUT);
    }

    @Override
    @Autowired
    public void kStreamDummyTwoLowercase(StreamsBuilder builder) {
        builder.stream(TOPIC_TWO, Consumed.with(Serdes.String(), Serdes.String()))
                .mapValues(s -> s.toLowerCase())
                .to(TOPIC_TWO_LOWER_TARGET, Produced.with(Serdes.String(), Serdes.String()));
    }
}
