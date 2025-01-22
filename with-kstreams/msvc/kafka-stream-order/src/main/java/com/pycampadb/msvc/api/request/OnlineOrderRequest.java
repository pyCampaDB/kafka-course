package com.pycampadb.msvc.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class OnlineOrderRequest {
    private String onlineOrderNumber;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime orderDateTime;
    private int totalAmount;
    private  String username;

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
        return "OnlineOrderRequest{" +
                "onlineOrderNumber='" + onlineOrderNumber + '\'' +
                ", orderDateTime=" + orderDateTime +
                ", totalAmount=" + totalAmount +
                ", username='" + username + '\'' +
                '}';
    }
}
