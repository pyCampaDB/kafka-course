package com.pycampadb.msvc.command.service.impl;

import com.pycampadb.msvc.api.request.CustomerPreferenceShoppingCartRequest;
import com.pycampadb.msvc.api.request.CustomerPreferenceWishlistRequest;
import com.pycampadb.msvc.command.action.CustomerPreferenceAction;
import com.pycampadb.msvc.command.service.CustomerPreferenceService;
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
