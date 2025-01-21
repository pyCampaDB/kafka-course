package com.pycampadb.msvc.broker.stream.flashsale;

import org.apache.kafka.streams.StreamsBuilder;

public interface FlashSaleVoteStream {
    void flashSaleVoteStream(StreamsBuilder builder);
}
