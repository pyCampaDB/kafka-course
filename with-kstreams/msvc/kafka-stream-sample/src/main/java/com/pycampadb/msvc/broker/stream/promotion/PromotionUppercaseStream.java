package com.pycampadb.msvc.broker.stream.promotion;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;

public interface PromotionUppercaseStream {
    KStream<String, String> kstreamPromotionUppercase(StreamsBuilder builder);
}
