package com.pycampadb.msvc.broker.stream.premium;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.streams.StreamsBuilder;

public interface PremiumOfferStream {
    void kStreamPremiumOffer(StreamsBuilder builder, ObjectMapper mapper);
}
