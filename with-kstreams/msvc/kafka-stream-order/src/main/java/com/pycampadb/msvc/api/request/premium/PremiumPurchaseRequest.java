package com.pycampadb.msvc.api.request.premium;

public class PremiumPurchaseRequest {
    private String item;
    private String purchaseNumber;
    private String username;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PremiumPurchaseRequest{" +
                "item='" + item + '\'' +
                ", purchaseNumber='" + purchaseNumber + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
