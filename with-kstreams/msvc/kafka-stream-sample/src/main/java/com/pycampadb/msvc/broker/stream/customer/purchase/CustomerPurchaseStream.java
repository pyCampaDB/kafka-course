package com.pycampadb.msvc.broker.stream.customer.purchase;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;

public interface CustomerPurchaseStream {
    KStream<String, String> kStreamCustomerPurchase(StreamsBuilder builder);
}
