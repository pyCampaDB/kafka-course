package com.pycampadb.msvc.broker.consumer;

import com.pycampadb.msvc.broker.message.DiscountMessage;
import com.pycampadb.msvc.broker.message.PromotionMessage;

public interface PromotionConsumer {
    void listenPromotion(PromotionMessage message);
    void listenDiscount(DiscountMessage message);
}
