package com.pycampadb.msvc.broker.message;

public class FlashSaleVoteMessage {
    private String customerId;
    private String itemName;

    public FlashSaleVoteMessage() {
    }

    public FlashSaleVoteMessage(String customerId, String itemName) {
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
        return "FlashSaleVoteMessage{" +
                "customerId='" + customerId + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
