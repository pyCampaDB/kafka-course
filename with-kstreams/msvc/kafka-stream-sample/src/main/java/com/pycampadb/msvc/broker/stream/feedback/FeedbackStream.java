package com.pycampadb.msvc.broker.stream.feedback;


import org.apache.kafka.streams.StreamsBuilder;

public interface FeedbackStream {
    void kStreamFeedback(StreamsBuilder builder);
}
