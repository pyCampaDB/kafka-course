package com.pycampadb.msvc.broker.producer.customer.purchase.impl;

import com.pycampadb.msvc.broker.message.customer.purchase.CustomerPurchaseMobileMessage;
import com.pycampadb.msvc.broker.message.customer.purchase.CustomerPurchaseWebMessage;
import com.pycampadb.msvc.broker.producer.customer.purchase.CustomerPurchaseProducer;
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
