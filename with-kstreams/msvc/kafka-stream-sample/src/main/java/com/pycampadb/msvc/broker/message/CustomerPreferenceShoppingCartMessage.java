package com.pycampadb.msvc.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class CustomerPreferenceShoppingCartMessage {
    private String customerId;
    private String itemName;
    private int cartAmount;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime cartDateTime;

    public CustomerPreferenceShoppingCartMessage() {
    }

    public CustomerPreferenceShoppingCartMessage(String customerId, String itemName, int cartAmount, OffsetDateTime cartDateTime) {
        super();
        this.customerId = customerId;
        this.itemName = itemName;
        this.cartAmount = cartAmount;
        this.cartDateTime = cartDateTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(int cartAmount) {
        this.cartAmount = cartAmount;
    }

    public OffsetDateTime getCartDateTime() {
        return cartDateTime;
    }

    public void setCartDateTime(OffsetDateTime cartDateTime) {
        this.cartDateTime = cartDateTime;
    }

    @Override
    public String toString() {
        return "CustomerPreferenceShoppingCartMessage{" +
                "customerId='" + customerId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", cartAmount=" + cartAmount +
                ", cartDateTime=" + cartDateTime +
                '}';
    }
}
