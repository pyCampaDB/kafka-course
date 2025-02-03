package com.pycampadb.msvc.command.action.customer.preference;

import com.pycampadb.msvc.api.request.customer.preference.CustomerPreferenceShoppingCartRequest;
import com.pycampadb.msvc.api.request.customer.preference.CustomerPreferenceWishlistRequest;

public interface CustomerPreferenceAction {
    String sendShoppingCartToKafka(CustomerPreferenceShoppingCartRequest request);
    String sendWishlistToKafka(CustomerPreferenceWishlistRequest request);
}
