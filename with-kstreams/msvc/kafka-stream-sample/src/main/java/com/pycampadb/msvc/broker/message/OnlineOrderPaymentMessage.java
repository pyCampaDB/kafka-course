package com.pycampadb.msvc.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class OnlineOrderPaymentMessage {
    private String onlineOrderNumber;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime orderDateTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime paymentDateTime;
    private String paymentMethod;
    private String paymentNumber;
    private int totalAmount;
    private String username;

    public OnlineOrderPaymentMessage() {
    }

    public OnlineOrderPaymentMessage(String onlineOrderNumber, OffsetDateTime paymentDateTime, OffsetDateTime orderDateTime, String paymentMethod, String paymentNumber, int totalAmount, String username) {
        super();
        this.onlineOrderNumber = onlineOrderNumber;
        this.paymentDateTime = paymentDateTime;
        this.orderDateTime = orderDateTime;
        this.paymentMethod = paymentMethod;
        this.paymentNumber = paymentNumber;
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

    public OffsetDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(OffsetDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
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
        return "OnlineOrderPaymentMessage{" +
                "onlineOrderNumber='" + onlineOrderNumber + '\'' +
                ", orderDateTime=" + orderDateTime +
                ", paymentDateTime=" + paymentDateTime +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentNumber='" + paymentNumber + '\'' +
                ", totalAmount=" + totalAmount +
                ", username='" + username + '\'' +
                '}';
    }
}
