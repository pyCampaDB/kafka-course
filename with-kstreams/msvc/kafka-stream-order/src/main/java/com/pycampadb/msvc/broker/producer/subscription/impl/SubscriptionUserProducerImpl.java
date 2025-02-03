package com.pycampadb.msvc.broker.producer.subscription.impl;

import com.pycampadb.msvc.broker.message.subscription.SubscriptionUserMessage;
import com.pycampadb.msvc.broker.producer.subscription.SubscriptionUserProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionUserProducerImpl implements SubscriptionUserProducer {
    private final KafkaTemplate<String, SubscriptionUserMessage> kafkaTemplate;

    public SubscriptionUserProducerImpl(KafkaTemplate<String, SubscriptionUserMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishSubscriptionUser(SubscriptionUserMessage message) {
        kafkaTemplate.send("t-commodity-subscription-user", message.getUsername(), message);
    }
}
