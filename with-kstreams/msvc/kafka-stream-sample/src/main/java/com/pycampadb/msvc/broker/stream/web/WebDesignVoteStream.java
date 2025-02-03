package com.pycampadb.msvc.broker.stream.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.streams.StreamsBuilder;

public interface WebDesignVoteStream {
    void kStreamWebDesignVote (StreamsBuilder builder, ObjectMapper mapper);
}
