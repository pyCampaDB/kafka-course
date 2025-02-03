package com.pycampadb.msvc.broker.stream.subscription;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.streams.StreamsBuilder;

public interface SubscriptionOfferStream {
    void kStreamSubscriptionOffer (StreamsBuilder builder, ObjectMapper mapper);
}
