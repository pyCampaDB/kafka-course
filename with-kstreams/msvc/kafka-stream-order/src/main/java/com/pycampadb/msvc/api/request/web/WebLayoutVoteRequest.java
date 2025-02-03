package com.pycampadb.msvc.api.request.web;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class WebLayoutVoteRequest {
    private String layout;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime voteDateTime;

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public LocalDateTime getVoteDateTime() {
        return voteDateTime;
    }

    public void setVoteDateTime(LocalDateTime voteDateTime) {
        this.voteDateTime = voteDateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "WebLayoutVoteRequest{" +
                "layout='" + layout + '\'' +
                ", username='" + username + '\'' +
                ", voteDateTime=" + voteDateTime +
                '}';
    }
}
