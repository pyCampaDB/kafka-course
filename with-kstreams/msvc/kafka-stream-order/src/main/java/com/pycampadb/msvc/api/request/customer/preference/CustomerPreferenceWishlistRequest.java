package com.pycampadb.msvc.api.request.customer.preference;

public class CustomerPreferenceWishlistRequest {
    private String customerId;
    private String itemName;

    public CustomerPreferenceWishlistRequest() {
    }

    public CustomerPreferenceWishlistRequest(String customerId, String itemName) {
        super();
        this.customerId = customerId;
        this.itemName = itemName;
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

    @Override
    public String toString() {
        return "CustomerPreferenceWishlistRequest{" +
                "customerId='" + customerId + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
