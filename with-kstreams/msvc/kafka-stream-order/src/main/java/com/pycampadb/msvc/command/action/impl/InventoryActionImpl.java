package com.pycampadb.msvc.command.action.impl;

import com.pycampadb.msvc.api.request.InventoryRequest;
import com.pycampadb.msvc.broker.message.InventoryMessage;
import com.pycampadb.msvc.broker.producer.InventoryProducer;
import com.pycampadb.msvc.command.action.InventoryAction;
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
