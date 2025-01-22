package com.pycampadb.msvc.broker.stream.orderpayment;

import org.apache.kafka.streams.StreamsBuilder;

public interface OrderPaymentStream {
    void kStreamOrderPayment(StreamsBuilder builder);
}
