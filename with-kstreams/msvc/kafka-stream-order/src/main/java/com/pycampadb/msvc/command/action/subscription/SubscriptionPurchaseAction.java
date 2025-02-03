package com.pycampadb.msvc.command.action.subscription;

import com.pycampadb.msvc.api.request.subscription.SubscriptionPurchaseRequest;

public interface SubscriptionPurchaseAction {
    void createSubscriptionPurchase (SubscriptionPurchaseRequest request);
}
