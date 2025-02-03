package com.pycampadb.msvc.api.request.premium;

public class PremiumUserRequest {
    private String level;
    private String username;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PremiumUserRequest{" +
                "level='" + level + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
