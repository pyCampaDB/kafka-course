package com.pycampadb.msvc.command.service.premium;

import com.pycampadb.msvc.api.request.premium.PremiumUserRequest;

public interface PremiumUserService {
    void createPremiumUser (PremiumUserRequest request);
}
