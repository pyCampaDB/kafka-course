package com.pycampadb.msvc.broker.stream.promotion;

import org.apache.kafka.streams.StreamsBuilder;

public interface PromotionUppercaseJsonStream {
    void kstreamPromotionUppercase(StreamsBuilder builder);
}
