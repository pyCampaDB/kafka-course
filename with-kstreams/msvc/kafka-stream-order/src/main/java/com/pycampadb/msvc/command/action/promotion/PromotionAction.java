package com.pycampadb.msvc.command.action.promotion;

import com.pycampadb.msvc.api.request.promotion.PromotionRequest;
import com.pycampadb.msvc.broker.message.promotion.PromotionMessage;

public interface PromotionAction {
    PromotionMessage convertToPromotionMessage(PromotionRequest request);
    void sendToKafka(PromotionMessage message);
}
