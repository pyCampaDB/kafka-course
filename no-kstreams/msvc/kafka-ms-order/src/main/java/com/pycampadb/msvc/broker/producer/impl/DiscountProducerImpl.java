package com.pycampadb.msvc.broker.producer.impl;

import com.pycampadb.msvc.broker.message.DiscountMessage;
import com.pycampadb.msvc.broker.producer.DiscountProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DiscountProducerImpl implements DiscountProducer {
    private final KafkaTemplate<String, DiscountMessage> kafkaTemplate;

    public DiscountProducerImpl(KafkaTemplate<String, DiscountMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(DiscountMessage message) {
        kafkaTemplate.send("t-commodity-promotion", message);
    }
}
