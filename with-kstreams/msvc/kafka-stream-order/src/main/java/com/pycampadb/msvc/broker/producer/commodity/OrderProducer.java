package com.pycampadb.msvc.broker.producer.commodity;

import com.pycampadb.msvc.broker.message.commodity.OrderMessage;

public interface OrderProducer {
    void sendOrder(OrderMessage orderMessage);
}
