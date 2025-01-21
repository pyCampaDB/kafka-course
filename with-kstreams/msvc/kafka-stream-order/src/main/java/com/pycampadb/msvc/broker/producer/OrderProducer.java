package com.pycampadb.msvc.broker.producer;

import com.pycampadb.msvc.broker.message.OrderMessage;

public interface OrderProducer {
    void sendOrder(OrderMessage orderMessage);
}
