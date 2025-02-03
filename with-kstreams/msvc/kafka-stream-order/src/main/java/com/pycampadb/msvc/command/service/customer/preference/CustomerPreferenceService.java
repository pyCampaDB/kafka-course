package com.pycampadb.msvc.command.service.customer.preference;

import com.pycampadb.msvc.api.request.customer.preference.CustomerPreferenceShoppingCartRequest;
import com.pycampadb.msvc.api.request.customer.preference.CustomerPreferenceWishlistRequest;

public interface CustomerPreferenceService {
    String publishShoppingCartToKafka(CustomerPreferenceShoppingCartRequest request);
    String publishWishlistToKafka(CustomerPreferenceWishlistRequest request);
}
