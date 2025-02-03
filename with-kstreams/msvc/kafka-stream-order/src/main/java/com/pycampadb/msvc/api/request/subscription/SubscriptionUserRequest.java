package com.pycampadb.msvc.api.request.subscription;

public class SubscriptionUserRequest {
    private String duration;
    private String username;

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
