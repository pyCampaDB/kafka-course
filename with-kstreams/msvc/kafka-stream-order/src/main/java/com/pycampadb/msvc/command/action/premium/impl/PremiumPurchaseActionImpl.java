package com.pycampadb.msvc.command.action.premium.impl;

import com.pycampadb.msvc.api.request.premium.PremiumPurchaseRequest;
import com.pycampadb.msvc.broker.message.premium.PremiumPurchaseMessage;
import com.pycampadb.msvc.broker.producer.premium.PremiumPurchaseProducer;
import com.pycampadb.msvc.command.action.premium.PremiumPurchaseAction;
import org.springframework.stereotype.Component;

@Component
public class PremiumPurchaseActionImpl implements PremiumPurchaseAction {
    private final PremiumPurchaseProducer producer;

    public PremiumPurchaseActionImpl(PremiumPurchaseProducer producer) {
        this.producer = producer;
    }

    @Override
    public void sendToKafka(PremiumPurchaseRequest request) {
        producer.publishPremiumPurchase(new PremiumPurchaseMessage(request.getItem(), request.getPurchaseNumber(), request.getUsername()));
    }
}
