package com.pycampadb.msvc.command.service.premium.impl;

import com.pycampadb.msvc.api.request.premium.PremiumPurchaseRequest;
import com.pycampadb.msvc.command.action.premium.PremiumPurchaseAction;
import com.pycampadb.msvc.command.service.premium.PremiumPurchaseService;
import org.springframework.stereotype.Service;

@Service
public class PremiumPurchaseServiceImpl implements PremiumPurchaseService {
    private final PremiumPurchaseAction action;

    public PremiumPurchaseServiceImpl(PremiumPurchaseAction action) {
        this.action = action;
    }

    @Override
    public void createPremiumPurchase(PremiumPurchaseRequest request) {
        action.sendToKafka(request);
    }
}
