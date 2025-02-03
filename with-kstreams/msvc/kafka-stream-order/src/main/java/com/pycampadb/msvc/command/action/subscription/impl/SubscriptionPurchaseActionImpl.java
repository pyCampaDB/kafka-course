package com.pycampadb.msvc.command.action.subscription.impl;

import com.pycampadb.msvc.api.request.subscription.SubscriptionPurchaseRequest;
import com.pycampadb.msvc.broker.message.subscription.SubscriptionPurchaseMessage;
import com.pycampadb.msvc.broker.producer.subscription.SubscriptionPurchaseProducer;
import com.pycampadb.msvc.command.action.subscription.SubscriptionPurchaseAction;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionPurchaseActionImpl implements SubscriptionPurchaseAction {
    private final SubscriptionPurchaseProducer producer;

    public SubscriptionPurchaseActionImpl(SubscriptionPurchaseProducer producer) {
        this.producer = producer;
    }

    @Override
    public void createSubscriptionPurchase(SubscriptionPurchaseRequest request) {
        producer.publishSubscriptionPurchase(new SubscriptionPurchaseMessage(request.getSubscriptionNumber(), request.getUsername()));
    }
}
