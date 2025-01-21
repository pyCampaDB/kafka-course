package com.pycampadb.msvc.api.request;

public class CustomerPreferenceShoppingCartRequest {
    private String customerId;
    private String itemName;
    private int cartAmount;

    public CustomerPreferenceShoppingCartRequest() {
    }

    public CustomerPreferenceShoppingCartRequest(String customerId, String itemName, int cartAmount) {
        super();
        this.customerId = customerId;
        this.itemName = itemName;
        this.cartAmount = cartAmount;
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

    @Override
    public String toString() {
        return "CustomerPreferenceShoppingCartRequest{" +
                "customerId='" + customerId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", cartAmount=" + cartAmount +
                '}';
    }
}
