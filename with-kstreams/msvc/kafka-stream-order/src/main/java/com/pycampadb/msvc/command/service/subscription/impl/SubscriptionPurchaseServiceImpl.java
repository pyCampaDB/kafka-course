package com.pycampadb.msvc.command.service.subscription.impl;

import com.pycampadb.msvc.api.request.subscription.SubscriptionPurchaseRequest;
import com.pycampadb.msvc.command.action.subscription.SubscriptionPurchaseAction;
import com.pycampadb.msvc.command.service.subscription.SubscriptionPurchaseService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionPurchaseServiceImpl implements SubscriptionPurchaseService {
    private final SubscriptionPurchaseAction action;

    public SubscriptionPurchaseServiceImpl(SubscriptionPurchaseAction action) {
        this.action = action;
    }

    @Override
    public void createSubscriptionPurchase(SubscriptionPurchaseRequest request) {
        action.createSubscriptionPurchase(request);
    }
}
