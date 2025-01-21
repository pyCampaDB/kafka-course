package com.pycampadb.msvc.broker.stream.commodity;

import org.apache.kafka.streams.StreamsBuilder;

public interface MaskOrderStream {
    void kStreamCommodityMask (StreamsBuilder builder);
}
