package com.pycampadb.msvc.command.action.premium;

import com.pycampadb.msvc.api.request.premium.PremiumPurchaseRequest;

public interface PremiumPurchaseAction {
    void sendToKafka(PremiumPurchaseRequest request);
}
