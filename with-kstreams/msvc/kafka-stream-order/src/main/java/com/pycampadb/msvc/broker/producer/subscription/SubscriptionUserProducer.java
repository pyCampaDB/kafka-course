package com.pycampadb.msvc.broker.producer.subscription;

import com.pycampadb.msvc.broker.message.subscription.SubscriptionUserMessage;

public interface SubscriptionUserProducer {
    void publishSubscriptionUser(SubscriptionUserMessage message);
}
