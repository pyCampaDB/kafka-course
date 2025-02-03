package com.pycampadb.msvc.broker.message.premium;

public class PremiumUserMessage {
    private String level;
    private String username;

    public PremiumUserMessage() {
    }

    public PremiumUserMessage(String level, String username) {
        super();
        this.level = level;
        this.username = username;
    }

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
