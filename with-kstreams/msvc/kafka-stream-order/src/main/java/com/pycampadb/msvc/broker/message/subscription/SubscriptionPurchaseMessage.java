package com.pycampadb.msvc.broker.message.subscription;

public class SubscriptionPurchaseMessage {
    private String subscriptionNumber;
    private String username;

    public SubscriptionPurchaseMessage(){}

    public SubscriptionPurchaseMessage(String subscriptionNumber, String username) {
        super();
        this.subscriptionNumber = subscriptionNumber;
        this.username = username;
    }

    public String getSubscriptionNumber() {
        return subscriptionNumber;
    }

    public void setSubscriptionNumber(String subscriptionNumber) {
        this.subscriptionNumber = subscriptionNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SubscriptionPurchaseRequest{" +
                "subscriptionNumber='" + subscriptionNumber + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
