package com.pycampadb.msvc.command.action.inventory.impl;

import com.pycampadb.msvc.api.request.inventory.InventoryRequest;
import com.pycampadb.msvc.broker.message.inventory.InventoryMessage;
import com.pycampadb.msvc.broker.producer.inventory.InventoryProducer;
import com.pycampadb.msvc.command.action.inventory.InventoryAction;
import org.springframework.stereotype.Component;

@Component
public class InventoryActionImpl implements InventoryAction {
    private final InventoryProducer producer;

    public InventoryActionImpl(InventoryProducer producer) {
        this.producer = producer;
    }

    @Override
    public void sendInventoryMessageToKafka(InventoryRequest request, String type) {
        var inventoryMessage = new InventoryMessage(
                request.getItem(),
                request.getLocation(),
                request.getQuantity(),
                type,
                request.getTransactionTime()
        );

        producer.sendInventoryMessage(inventoryMessage);
    }
}
