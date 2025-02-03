package com.pycampadb.msvc.command.service.subscription.impl;

import com.pycampadb.msvc.api.request.subscription.SubscriptionUserRequest;
import com.pycampadb.msvc.command.action.subscription.SubscriptionUserAction;
import com.pycampadb.msvc.command.service.subscription.SubscriptionUserService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionUserServiceImpl implements SubscriptionUserService {
    private final SubscriptionUserAction action;

    public SubscriptionUserServiceImpl(SubscriptionUserAction action) {
        this.action = action;
    }

    @Override
    public void createSubscriptionUser(SubscriptionUserRequest request) {
        action.createSubscriptionUser(request);
    }
}
