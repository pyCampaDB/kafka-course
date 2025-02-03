package com.pycampadb.ui.broker.stream;

import org.apache.kafka.streams.StreamsBuilder;

public interface KafkaUiStream {
    void kStreamDummy (StreamsBuilder builder);
    void kStreamDummyTwoLowercase (StreamsBuilder builder);
}
