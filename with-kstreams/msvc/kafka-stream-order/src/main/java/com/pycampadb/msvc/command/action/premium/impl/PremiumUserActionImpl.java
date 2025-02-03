package com.pycampadb.msvc.command.action.premium.impl;

import com.pycampadb.msvc.api.request.premium.PremiumPurchaseRequest;
import com.pycampadb.msvc.api.request.premium.PremiumUserRequest;
import com.pycampadb.msvc.broker.message.premium.PremiumUserMessage;
import com.pycampadb.msvc.broker.producer.premium.PremiumUserProducer;
import com.pycampadb.msvc.command.action.premium.PremiumUserAction;
import org.springframework.stereotype.Component;

@Component
public class PremiumUserActionImpl implements PremiumUserAction {
    private final PremiumUserProducer producer;

    public PremiumUserActionImpl(PremiumUserProducer producer) {
        this.producer = producer;
    }

    @Override
    public void sendToKafka(PremiumUserRequest request) {
        producer.publishPremiumUser(new PremiumUserMessage(request.getLevel(), request.getUsername()));
    }
}
