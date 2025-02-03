package com.pycampadb.msvc.command.service.customer.preference.impl;

import com.pycampadb.msvc.api.request.customer.preference.CustomerPreferenceShoppingCartRequest;
import com.pycampadb.msvc.api.request.customer.preference.CustomerPreferenceWishlistRequest;
import com.pycampadb.msvc.command.action.customer.preference.CustomerPreferenceAction;
import com.pycampadb.msvc.command.service.customer.preference.CustomerPreferenceService;
import org.springframework.stereotype.Service;

@Service
public class CustomerPreferenceServiceImpl implements CustomerPreferenceService {
    private final CustomerPreferenceAction action;

    public CustomerPreferenceServiceImpl(CustomerPreferenceAction action) {
        this.action = action;
    }

    @Override
    public String publishShoppingCartToKafka(CustomerPreferenceShoppingCartRequest request) {
        return action.sendShoppingCartToKafka(request);
    }

    @Override
    public String publishWishlistToKafka(CustomerPreferenceWishlistRequest request) {
        return action.sendWishlistToKafka(request);
    }
}
