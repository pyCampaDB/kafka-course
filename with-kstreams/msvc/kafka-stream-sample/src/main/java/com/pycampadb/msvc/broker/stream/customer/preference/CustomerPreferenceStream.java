package com.pycampadb.msvc.broker.stream.customer.preference;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;

public interface CustomerPreferenceStream {
    KStream<String, Object> kStreamCustomerPreference(StreamsBuilder builder);
}
