package com.pycampadb.msvc.command.service.promotion.impl;

import com.pycampadb.msvc.api.request.promotion.PromotionRequest;
import com.pycampadb.msvc.command.action.promotion.PromotionAction;
import com.pycampadb.msvc.command.service.promotion.PromotionService;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {
    private final PromotionAction action;

    public PromotionServiceImpl(PromotionAction action) {
        this.action = action;
    }

    @Override
    public void createPromotion(PromotionRequest request) {
        var message = action.convertToPromotionMessage(request);
        action.sendToKafka(message);
    }
}
