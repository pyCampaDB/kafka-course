package com.pycampadb.msvc.broker.producer.discount;

import com.pycampadb.msvc.broker.message.discount.DiscountMessage;

public interface DiscountProducer {
    void publish (DiscountMessage message);
}
