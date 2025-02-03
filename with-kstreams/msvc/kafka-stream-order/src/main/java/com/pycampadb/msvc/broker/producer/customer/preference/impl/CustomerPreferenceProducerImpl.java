package com.pycampadb.msvc.broker.producer.customer.preference.impl;

import com.pycampadb.msvc.broker.message.customer.preference.CustomerPreferenceShoppingCartMessage;
import com.pycampadb.msvc.broker.message.customer.preference.CustomerPreferenceWishlistMessage;
import com.pycampadb.msvc.broker.producer.customer.preference.CustomerPreferenceProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerPreferenceProducerImpl implements CustomerPreferenceProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public CustomerPreferenceProducerImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendShoppingCart(CustomerPreferenceShoppingCartMessage message) {
        kafkaTemplate.send("t-commodity-customer-preference-shopping-cart", message.getCustomerId(), message);
    }

    @Override
    public void sendWishlist(CustomerPreferenceWishlistMessage message) {
        kafkaTemplate.send("t-commodity-customer-preference-wishlist", message.getCustomerId(), message);
    }
}
