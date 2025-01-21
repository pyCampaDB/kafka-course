package com.pycampadb.msvc.command.action.impl;

import com.pycampadb.msvc.api.request.PromotionRequest;
import com.pycampadb.msvc.broker.message.PromotionMessage;
import com.pycampadb.msvc.broker.producer.PromotionProducer;
import com.pycampadb.msvc.command.action.PromotionAction;
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
