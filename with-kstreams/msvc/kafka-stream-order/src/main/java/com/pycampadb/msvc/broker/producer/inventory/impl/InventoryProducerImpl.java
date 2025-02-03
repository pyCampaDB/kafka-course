package com.pycampadb.msvc.broker.producer.inventory.impl;

import com.pycampadb.msvc.broker.message.inventory.InventoryMessage;
import com.pycampadb.msvc.broker.producer.inventory.InventoryProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryProducerImpl implements InventoryProducer {
    private final KafkaTemplate<String, InventoryMessage> kafkaTemplate;

    public InventoryProducerImpl(KafkaTemplate<String, InventoryMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendInventoryMessage(InventoryMessage message) {
        kafkaTemplate.send("t-commodity-inventory", message.getItem(),message);
    }
}
