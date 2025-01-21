package com.pycampadb.msvc.broker.stream.promotion;

import org.apache.kafka.streams.StreamsBuilder;

public interface PromotionUppercaseSpringJsonStream {
    void kStreamPromotionUppercase(StreamsBuilder builder);
}
