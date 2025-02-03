package com.pycampadb.msvc.broker.producer.premium;

import com.pycampadb.msvc.broker.message.premium.PremiumUserMessage;

public interface PremiumUserProducer {
    void publishPremiumUser(PremiumUserMessage message);
}
