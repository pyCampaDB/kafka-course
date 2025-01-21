package com.pycampadb.msvc.broker.stream.promotion;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;

public interface PromotionUppercase2Stream {
    void kstreamPromotionUppercase(StreamsBuilder builder);
}
