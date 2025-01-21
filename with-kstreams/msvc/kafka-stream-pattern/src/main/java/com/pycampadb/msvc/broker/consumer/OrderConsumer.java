package com.pycampadb.msvc.broker.consumer;

import com.pycampadb.msvc.broker.message.OrderMessage;

public interface OrderConsumer {
    void listenOrder(OrderMessage orderMessage);
}
