package com.pycampadb.msvc.broker.message.inventory;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class InventoryMessage {
    private String item;
    private String location;
    private long quantity;
    private String type;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime transactionTime;

    public InventoryMessage() {
    }

    public InventoryMessage(String item, String location, long quantity, String type, OffsetDateTime transactionTime) {
        super();
        this.item = item;
        this.location = location;
        this.quantity = quantity;
        this.type = type;
        this.transactionTime = transactionTime;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OffsetDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(OffsetDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "InventoryMessage{" +
                "item='" + item + '\'' +
                ", location='" + location + '\'' +
                ", quantity=" + quantity +
                ", type='" + type + '\'' +
                ", transactionTime=" + transactionTime +
                '}';
    }
}
