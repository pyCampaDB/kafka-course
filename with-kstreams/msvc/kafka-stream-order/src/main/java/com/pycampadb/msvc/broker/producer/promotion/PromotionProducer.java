package com.pycampadb.msvc.broker.producer.promotion;

import com.pycampadb.msvc.broker.message.promotion.PromotionMessage;

public interface PromotionProducer {
    void sendPromotion(PromotionMessage message);
}
