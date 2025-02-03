package com.pycampadb.msvc.command.action.subscription;

import com.pycampadb.msvc.api.request.subscription.SubscriptionUserRequest;

public interface SubscriptionUserAction {
    void createSubscriptionUser(SubscriptionUserRequest request);
}
