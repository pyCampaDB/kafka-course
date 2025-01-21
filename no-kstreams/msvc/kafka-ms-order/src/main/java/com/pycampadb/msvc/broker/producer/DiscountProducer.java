package com.pycampadb.msvc.broker.producer;

import com.pycampadb.msvc.broker.message.DiscountMessage;

public interface DiscountProducer {
    void publish (DiscountMessage message);
}
