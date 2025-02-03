package com.pycampadb.msvc.command.action.promotion.impl;

import com.pycampadb.msvc.api.request.promotion.PromotionRequest;
import com.pycampadb.msvc.broker.message.promotion.PromotionMessage;
import com.pycampadb.msvc.broker.producer.promotion.PromotionProducer;
import com.pycampadb.msvc.command.action.promotion.PromotionAction;
import org.springframework.stereotype.Component;

@Component
public class PromotionActionImpl implements PromotionAction {
    private final PromotionProducer producer;

    public PromotionActionImpl(PromotionProducer producer) {
        this.producer = producer;
    }


    @Override
    public PromotionMessage convertToPromotionMessage(PromotionRequest request) {
        return new PromotionMessage(request.getPromotionCode());
    }

    @Override
    public void sendToKafka(PromotionMessage message) {
        producer.sendPromotion(message);
    }
}
