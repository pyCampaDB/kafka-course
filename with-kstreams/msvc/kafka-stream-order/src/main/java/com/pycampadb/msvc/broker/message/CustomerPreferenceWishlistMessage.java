package com.pycampadb.msvc.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class CustomerPreferenceWishlistMessage {
    private String customerId;
    private String itemName;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime wishlistDateTime;

    public CustomerPreferenceWishlistMessage() {
    }

    public CustomerPreferenceWishlistMessage(String customerId, String itemName, OffsetDateTime wishlistDateTime) {
        super();
        this.customerId = customerId;
        this.itemName = itemName;
        this.wishlistDateTime = wishlistDateTime;
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

    public OffsetDateTime getWishlistDateTime() {
        return wishlistDateTime;
    }

    public void setWishlistDateTime(OffsetDateTime wishlistDateTime) {
        this.wishlistDateTime = wishlistDateTime;
    }

    @Override
    public String toString() {
        return "CustomerPreferenceWishlistMessage{" +
                "customerId='" + customerId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", wishlistDateTime=" + wishlistDateTime +
                '}';
    }
}
