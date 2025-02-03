package com.pycampadb.msvc.broker.producer.premium.impl;

import com.pycampadb.msvc.broker.message.premium.PremiumPurchaseMessage;
import com.pycampadb.msvc.broker.producer.premium.PremiumPurchaseProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PremiumPurchaseProducerImpl implements PremiumPurchaseProducer {
    private final KafkaTemplate<String, PremiumPurchaseMessage> kafkaTemplate;

    public PremiumPurchaseProducerImpl(KafkaTemplate<String, PremiumPurchaseMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishPremiumPurchase(PremiumPurchaseMessage message) {
        kafkaTemplate.send("t-commodity-premium-purchase", message.getPurchaseNumber(), message);
    }
}
