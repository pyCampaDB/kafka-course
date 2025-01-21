package com.pycampadb.msvc.broker.producer;

import com.pycampadb.msvc.broker.message.PromotionMessage;

public interface PromotionProducer {
    void sendPromotion(PromotionMessage message);
}
