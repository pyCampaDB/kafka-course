package com.pycampadb.msvc.api.request.inventory;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class InventoryRequest {
    private String item;
    private long quantity;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime transactionTime;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public OffsetDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(OffsetDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "InventoryRequest{" +
                "item='" + item + '\'' +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                ", transactionTime=" + transactionTime +
                '}';
    }
}
