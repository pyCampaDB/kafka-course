package com.pycampadb.msvc.broker.producer.subscription;

import com.pycampadb.msvc.broker.message.subscription.SubscriptionPurchaseMessage;

public interface SubscriptionPurchaseProducer {
    void publishSubscriptionPurchase (SubscriptionPurchaseMessage message);
}
