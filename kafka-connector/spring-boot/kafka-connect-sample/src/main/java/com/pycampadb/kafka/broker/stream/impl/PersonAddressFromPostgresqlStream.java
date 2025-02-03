package com.pycampadb.kafka.broker.stream.impl;

import com.pycampadb.kafka.broker.stream.PersonAddressStream;
import org.apache.kafka.streams.StreamsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonAddressFromPostgresqlStream implements PersonAddressStream {
    @Override
    @Autowired
    public void kStreamPersonAddress(StreamsBuilder builder) {
        var sourceStream = builder.stream("t-person-address-postgresql");

        sourceStream.to("t-person-address-target");
    }
}
