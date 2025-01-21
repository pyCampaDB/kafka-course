package com.pycampadb.msvc.command.action;

import com.pycampadb.msvc.api.request.PromotionRequest;
import com.pycampadb.msvc.broker.message.PromotionMessage;

public interface PromotionAction {
    PromotionMessage convertToPromotionMessage(PromotionRequest request);
    void sendToKafka(PromotionMessage message);
}
