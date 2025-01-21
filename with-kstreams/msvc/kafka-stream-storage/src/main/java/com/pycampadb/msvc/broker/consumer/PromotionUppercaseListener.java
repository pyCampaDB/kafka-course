package com.pycampadb.msvc.broker.consumer;

import com.pycampadb.msvc.broker.message.PromotionMessage;

public interface PromotionUppercaseListener {
    void listenPromotion(PromotionMessage message);
}
