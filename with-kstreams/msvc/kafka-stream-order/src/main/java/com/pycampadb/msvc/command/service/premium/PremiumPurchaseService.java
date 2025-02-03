package com.pycampadb.msvc.command.service.premium;

import com.pycampadb.msvc.api.request.premium.PremiumPurchaseRequest;

public interface PremiumPurchaseService {
    void createPremiumPurchase(PremiumPurchaseRequest request);
}
