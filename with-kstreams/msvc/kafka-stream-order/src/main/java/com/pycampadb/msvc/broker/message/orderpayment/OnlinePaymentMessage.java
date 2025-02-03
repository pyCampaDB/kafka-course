package com.pycampadb.msvc.broker.message.orderpayment;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class OnlinePaymentMessage {
    private String onlineOrderNumber;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime paymentDateTime;
    private String paymentMethod;
    private String paymentNumber;

    public OnlinePaymentMessage() {
    }

    public OnlinePaymentMessage(String onlineOrderNumber, OffsetDateTime paymentDateTime, String paymentNumber, String paymentMethod) {
        super();
        this.onlineOrderNumber = onlineOrderNumber;
        this.paymentDateTime = paymentDateTime;
        this.paymentNumber = paymentNumber;
        this.paymentMethod = paymentMethod;
    }

    public String getOnlineOrderNumber() {
        return onlineOrderNumber;
    }

    public void setOnlineOrderNumber(String onlineOrderNumber) {
        this.onlineOrderNumber = onlineOrderNumber;
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

    @Override
    public String toString() {
        return "OnlinePaymentMessage{" +
                "onlineOrderNumber='" + onlineOrderNumber + '\'' +
                ", paymentDateTime=" + paymentDateTime +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentNumber='" + paymentNumber + '\'' +
                '}';
    }
}
