package com.pycampadb.msvc.broker.producer.inventory;

import com.pycampadb.msvc.broker.message.inventory.InventoryMessage;

public interface InventoryProducer {
    void sendInventoryMessage(InventoryMessage message);
}
