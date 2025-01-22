package com.pycampadb.msvc.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class OnlineOrderMessage {
    private String onlineOrderNumber;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime orderDateTime;
    private int totalAmount;
    private String username;

    public OnlineOrderMessage() {
    }

    public OnlineOrderMessage(String onlineOrderNumber, OffsetDateTime orderDateTime, int totalAmount, String username) {
        super();
        this.onlineOrderNumber = onlineOrderNumber;
        this.orderDateTime = orderDateTime;
        this.totalAmount = totalAmount;
        this.username = username;
    }

    public String getOnlineOrderNumber() {
        return onlineOrderNumber;
    }

    public void setOnlineOrderNumber(String onlineOrderNumber) {
        this.onlineOrderNumber = onlineOrderNumber;
    }

    public OffsetDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(OffsetDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "OnlineOrderMessage{" +
                "onlineOrderNumber='" + onlineOrderNumber + '\'' +
                ", orderDateTime=" + orderDateTime +
                ", totalAmount=" + totalAmount +
                ", username='" + username + '\'' +
                '}';
    }
}
