package com.pycampadb.msvc.broker.producer;

import com.pycampadb.msvc.api.request.CustomerPreferenceWishlistRequest;
import com.pycampadb.msvc.broker.message.CustomerPreferenceShoppingCartMessage;
import com.pycampadb.msvc.broker.message.CustomerPreferenceWishlistMessage;

public interface CustomerPreferenceProducer {
    void sendShoppingCart(CustomerPreferenceShoppingCartMessage message);
    void sendWishlist(CustomerPreferenceWishlistMessage message);
}
