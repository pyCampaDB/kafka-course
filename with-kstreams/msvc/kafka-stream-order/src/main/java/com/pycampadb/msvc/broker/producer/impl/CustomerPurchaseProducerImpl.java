package com.pycampadb.msvc.broker.producer.impl;

import com.pycampadb.msvc.broker.message.CustomerPurchaseMobileMessage;
import com.pycampadb.msvc.broker.message.CustomerPurchaseWebMessage;
import com.pycampadb.msvc.broker.producer.CustomerPurchaseProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerPurchaseProducerImpl implements CustomerPurchaseProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public CustomerPurchaseProducerImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishCustomerPurchaseWebMessage(CustomerPurchaseWebMessage message) {
        kafkaTemplate.send("t-commodity-customer-purchase-web", message.getPurchaseNumber(),message);
    }

    @Override
    public void publishCustomerPurchaseMobileMessage(CustomerPurchaseMobileMessage message) {
        kafkaTemplate.send("t-commodity-customer-purchase-mobile", message.getPurchaseNumber(),message);
    }
}
