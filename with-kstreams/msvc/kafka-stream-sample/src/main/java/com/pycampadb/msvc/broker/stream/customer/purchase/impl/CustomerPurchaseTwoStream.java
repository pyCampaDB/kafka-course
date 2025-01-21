package com.pycampadb.msvc.broker.stream.customer.purchase.impl;

import com.pycampadb.msvc.broker.stream.customer.purchase.CustomerPurchaseStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;


import java.util.List;

//@Configuration
public class CustomerPurchaseTwoStream implements CustomerPurchaseStream {

    @Override
    //@Bean
    public KStream<String, String> kStreamCustomerPurchase(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var topics = List.of("t-commodity-customer-purchase-mobile", "t-commodity-customer-purchase-web");

        var streams = builder.stream(topics, Consumed.with(stringSerde, stringSerde));
        streams.to("t-commodity-customer-purchase-all");
        return streams;
    }
}
