package com.pycampadb.msvc.broker.producer.premium.impl;

import com.pycampadb.msvc.broker.message.premium.PremiumUserMessage;
import com.pycampadb.msvc.broker.producer.premium.PremiumUserProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PremiumUserProducerImpl implements PremiumUserProducer {
    private final KafkaTemplate<String, PremiumUserMessage> kafkaTemplate;

    public PremiumUserProducerImpl(KafkaTemplate<String, PremiumUserMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishPremiumUser(PremiumUserMessage message) {
        kafkaTemplate.send("t-commodity-premium-user", message.getUsername(), message);
    }
}
