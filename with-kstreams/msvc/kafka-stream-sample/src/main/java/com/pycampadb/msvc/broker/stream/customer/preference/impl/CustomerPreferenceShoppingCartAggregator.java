package com.pycampadb.msvc.broker.stream.customer.preference.impl;

import com.pycampadb.msvc.broker.message.CustomerPreferenceAggregateMessage;
import com.pycampadb.msvc.broker.message.CustomerPreferenceShoppingCartMessage;
import org.apache.kafka.streams.kstream.Aggregator;

public class CustomerPreferenceShoppingCartAggregator
        implements Aggregator<String, CustomerPreferenceShoppingCartMessage, CustomerPreferenceAggregateMessage> {
    @Override
    public CustomerPreferenceAggregateMessage apply(String key,
                                                    CustomerPreferenceShoppingCartMessage value,
                                                    CustomerPreferenceAggregateMessage aggregate
    ) {
        aggregate.putShoppingCartItem(value.getItemName(), value.getCartDateTime());
        return aggregate;
    }
}
