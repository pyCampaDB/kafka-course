package com.pycampadb.msvc.broker.producer.premium;

import com.pycampadb.msvc.broker.message.premium.PremiumPurchaseMessage;

public interface PremiumPurchaseProducer {
    void publishPremiumPurchase(PremiumPurchaseMessage message);
}
