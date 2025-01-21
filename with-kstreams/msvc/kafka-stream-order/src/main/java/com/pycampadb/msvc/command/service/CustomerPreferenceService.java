package com.pycampadb.msvc.command.service;

import com.pycampadb.msvc.api.request.CustomerPreferenceShoppingCartRequest;
import com.pycampadb.msvc.api.request.CustomerPreferenceWishlistRequest;

public interface CustomerPreferenceService {
    String publishShoppingCartToKafka(CustomerPreferenceShoppingCartRequest request);
    String publishWishlistToKafka(CustomerPreferenceWishlistRequest request);
}
