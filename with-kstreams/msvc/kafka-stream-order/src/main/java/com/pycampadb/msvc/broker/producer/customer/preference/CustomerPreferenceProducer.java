package com.pycampadb.msvc.broker.producer.customer.preference;

import com.pycampadb.msvc.broker.message.customer.preference.CustomerPreferenceShoppingCartMessage;
import com.pycampadb.msvc.broker.message.customer.preference.CustomerPreferenceWishlistMessage;

public interface CustomerPreferenceProducer {
    void sendShoppingCart(CustomerPreferenceShoppingCartMessage message);
    void sendWishlist(CustomerPreferenceWishlistMessage message);
}
