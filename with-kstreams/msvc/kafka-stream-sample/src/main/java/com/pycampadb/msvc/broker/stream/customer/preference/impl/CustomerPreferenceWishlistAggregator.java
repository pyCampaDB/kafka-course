package com.pycampadb.msvc.broker.stream.customer.preference.impl;

import com.pycampadb.msvc.broker.message.CustomerPreferenceAggregateMessage;
import com.pycampadb.msvc.broker.message.CustomerPreferenceWishlistMessage;
import org.apache.kafka.streams.kstream.Aggregator;

public class CustomerPreferenceWishlistAggregator
        implements Aggregator<String, CustomerPreferenceWishlistMessage, CustomerPreferenceAggregateMessage> {
    @Override
    public CustomerPreferenceAggregateMessage apply(String key,
                                                      CustomerPreferenceWishlistMessage value,
                                                      CustomerPreferenceAggregateMessage aggregate) {
        aggregate.putWishlistItem(value.getItemName(), value.getWishlistDateTime());
        return aggregate;
    }
}
