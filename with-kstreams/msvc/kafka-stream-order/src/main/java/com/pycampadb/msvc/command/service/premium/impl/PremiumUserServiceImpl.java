package com.pycampadb.msvc.command.service.premium.impl;

import com.pycampadb.msvc.api.request.premium.PremiumUserRequest;
import com.pycampadb.msvc.command.action.premium.PremiumUserAction;
import com.pycampadb.msvc.command.service.premium.PremiumUserService;
import org.springframework.stereotype.Service;

@Service
public class PremiumUserServiceImpl implements PremiumUserService {
    private final PremiumUserAction action;

    public PremiumUserServiceImpl(PremiumUserAction action) {
        this.action = action;
    }

    @Override
    public void createPremiumUser(PremiumUserRequest request) {
        action.sendToKafka(request);
    }
}
