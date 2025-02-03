package com.pycampadb.msvc.api.request.subscription;

public class SubscriptionPurchaseRequest {
    private String subscriptionNumber;
    private String username;

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
