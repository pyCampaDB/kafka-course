package com.pycampadb.msvc.broker.message;

public class PremiumPurchaseMessage {
    private String item;
    private String purchaseNumber;
    private String username;

    public PremiumPurchaseMessage(){}

    public PremiumPurchaseMessage(String item, String purchaseNumber, String username) {
        super();
        this.item = item;
        this.purchaseNumber = purchaseNumber;
        this.username = username;
    }

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
