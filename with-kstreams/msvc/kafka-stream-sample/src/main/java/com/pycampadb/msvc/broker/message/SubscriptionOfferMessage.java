package com.pycampadb.msvc.broker.message;

public class SubscriptionOfferMessage {
    private String username;
    private String duration;
    private String subscriptionNumber;

    public SubscriptionOfferMessage() {
    }

    public SubscriptionOfferMessage(String username, String duration, String subscriptionNumber) {
        this.username = username;
        this.duration = duration;
        this.subscriptionNumber = subscriptionNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSubscriptionNumber() {
        return subscriptionNumber;
    }

    public void setSubscriptionNumber(String subscriptionNumber) {
        this.subscriptionNumber = subscriptionNumber;
    }

    @Override
    public String toString() {
        return "SubscriptionOfferMessage{" +
                "username='" + username + '\'' +
                ", duration='" + duration + '\'' +
                ", subscriptionNumber='" + subscriptionNumber + '\'' +
                '}';
    }
}
