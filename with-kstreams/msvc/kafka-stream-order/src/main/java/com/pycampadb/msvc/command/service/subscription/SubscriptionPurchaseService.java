package com.pycampadb.msvc.command.service.subscription;

import com.pycampadb.msvc.api.request.subscription.SubscriptionPurchaseRequest;

public interface SubscriptionPurchaseService {
    void createSubscriptionPurchase (SubscriptionPurchaseRequest request);
}
