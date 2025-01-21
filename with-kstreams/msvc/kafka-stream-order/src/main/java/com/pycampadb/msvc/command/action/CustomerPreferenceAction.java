package com.pycampadb.msvc.command.action;

import com.pycampadb.msvc.api.request.CustomerPreferenceShoppingCartRequest;
import com.pycampadb.msvc.api.request.CustomerPreferenceWishlistRequest;

public interface CustomerPreferenceAction {
    String sendShoppingCartToKafka(CustomerPreferenceShoppingCartRequest request);
    String sendWishlistToKafka(CustomerPreferenceWishlistRequest request);
}
