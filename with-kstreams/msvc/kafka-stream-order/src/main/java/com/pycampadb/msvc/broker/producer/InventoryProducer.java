package com.pycampadb.msvc.broker.producer;

import com.pycampadb.msvc.broker.message.InventoryMessage;

public interface InventoryProducer {
    void sendInventoryMessage(InventoryMessage message);
}
