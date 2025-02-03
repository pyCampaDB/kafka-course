package com.pycampadb.msvc.command.action.premium;


import com.pycampadb.msvc.api.request.premium.PremiumUserRequest;

public interface PremiumUserAction {
    void sendToKafka(PremiumUserRequest request);
}
