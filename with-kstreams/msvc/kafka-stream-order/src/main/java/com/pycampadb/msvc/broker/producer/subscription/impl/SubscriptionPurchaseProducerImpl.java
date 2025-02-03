package com.pycampadb.msvc.broker.producer.subscription.impl;

import com.pycampadb.msvc.broker.message.subscription.SubscriptionPurchaseMessage;
import com.pycampadb.msvc.broker.producer.subscription.SubscriptionPurchaseProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionPurchaseProducerImpl implements SubscriptionPurchaseProducer {
    private final KafkaTemplate<String, SubscriptionPurchaseMessage> kafkaTemplate;

    public SubscriptionPurchaseProducerImpl(KafkaTemplate<String, SubscriptionPurchaseMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishSubscriptionPurchase(SubscriptionPurchaseMessage message) {
        kafkaTemplate.send("t-commodity-subscription-purchase", message.getUsername(), message);
    }
}
