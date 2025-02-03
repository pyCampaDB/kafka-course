package com.pycampadb.msvc.api.request.orderpayment;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class OnlinePaymentRequest {
    private String onlineOrderNumber;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime paymentDateTime;
    private String paymentMethod;

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

    @Override
    public String toString() {
        return "OnlinePaymentRequest{" +
                "onlineOrderNumber='" + onlineOrderNumber + '\'' +
                ", paymentDateTime=" + paymentDateTime +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
