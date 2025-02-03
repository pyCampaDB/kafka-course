package com.pycampadb.msvc.broker.message;

public class SubscriptionUserMessage {
    private String duration;
    private String username;

    public SubscriptionUserMessage(){}

    public SubscriptionUserMessage(String duration, String username) {
        super();
        this.duration = duration;
        this.username = username;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SubscriptionUserRequest{" +
                "duration='" + duration + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
