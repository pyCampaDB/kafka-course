package com.pycampadb.kafka.broker.stream;

import org.apache.kafka.streams.StreamsBuilder;

public interface PersonAddressStream {
    void kStreamPersonAddress(StreamsBuilder builder);
}
