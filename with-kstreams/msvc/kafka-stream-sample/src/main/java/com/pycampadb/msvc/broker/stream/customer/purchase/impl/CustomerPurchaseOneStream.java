package com.pycampadb.msvc.broker.stream.customer.purchase.impl;

import com.pycampadb.msvc.broker.stream.customer.purchase.CustomerPurchaseStream;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;


//@Configuration
public class CustomerPurchaseOneStream implements CustomerPurchaseStream {

    @Override
    //@Bean
    public KStream<String, String> kStreamCustomerPurchase(StreamsBuilder builder) {
        var stringSerde = Serdes.String();
        var customerPurchaseMobileStream = builder.stream(
                "t-commodity-customer-purchase-mobile", Consumed.with(stringSerde, stringSerde)
        );

        var customerPurchaseWebStream = builder.stream(
                "t-commodity-customer-purchase-web", Consumed.with(stringSerde, stringSerde)
        );

        customerPurchaseMobileStream.merge(customerPurchaseWebStream).to("t-commodity-customer-purchase-all");
        return customerPurchaseMobileStream; //o customerPurchaseWebStream, da igual
    }
}
