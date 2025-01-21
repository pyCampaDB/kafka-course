package com.pycampadb.msvc.command.action.impl;

import com.pycampadb.msvc.api.request.CustomerPreferenceShoppingCartRequest;
import com.pycampadb.msvc.api.request.CustomerPreferenceWishlistRequest;
import com.pycampadb.msvc.broker.message.CustomerPreferenceShoppingCartMessage;
import com.pycampadb.msvc.broker.message.CustomerPreferenceWishlistMessage;
import com.pycampadb.msvc.broker.producer.CustomerPreferenceProducer;
import com.pycampadb.msvc.command.action.CustomerPreferenceAction;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class CustomerPreferenceActionImpl implements CustomerPreferenceAction {
    private final CustomerPreferenceProducer producer;

    public CustomerPreferenceActionImpl(CustomerPreferenceProducer producer) {
        this.producer = producer;
    }

    @Override
    public String sendShoppingCartToKafka(CustomerPreferenceShoppingCartRequest request) {
        var shoppingCartMessage = new CustomerPreferenceShoppingCartMessage(
                request.getCustomerId(),
                request.getItemName(),
                request.getCartAmount(),
                OffsetDateTime.now()
        );
        producer.sendShoppingCart(shoppingCartMessage);
        return shoppingCartMessage.getCustomerId();
    }

    @Override
    public String sendWishlistToKafka(CustomerPreferenceWishlistRequest request) {
        var wishlistMessage = new CustomerPreferenceWishlistMessage(
                request.getCustomerId(),
                request.getItemName(),
                OffsetDateTime.now()
        );

        producer.sendWishlist(wishlistMessage);

        return wishlistMessage.getCustomerId();
    }
}
