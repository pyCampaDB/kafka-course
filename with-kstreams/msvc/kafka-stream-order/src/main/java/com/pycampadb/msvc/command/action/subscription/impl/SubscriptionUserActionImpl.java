package com.pycampadb.msvc.command.action.subscription.impl;

import com.pycampadb.msvc.api.request.subscription.SubscriptionUserRequest;
import com.pycampadb.msvc.broker.message.subscription.SubscriptionUserMessage;
import com.pycampadb.msvc.broker.producer.subscription.SubscriptionUserProducer;
import com.pycampadb.msvc.command.action.subscription.SubscriptionUserAction;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionUserActionImpl implements SubscriptionUserAction {
    private final SubscriptionUserProducer producer;

    public SubscriptionUserActionImpl(SubscriptionUserProducer producer) {
        this.producer = producer;
    }

    @Override
    public void createSubscriptionUser(SubscriptionUserRequest request) {
        producer.publishSubscriptionUser(new SubscriptionUserMessage(request.getDuration(), request.getUsername()));
    }
}
