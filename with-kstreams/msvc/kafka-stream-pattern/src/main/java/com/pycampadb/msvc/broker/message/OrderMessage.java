package com.pycampadb.msvc.broker.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class OrderMessage {
    private String orderLocation;
    private String orderNumber;
    private String creditCardNumber;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private OffsetDateTime orderDateTime;
    private String itemName;
    private int price;
    private int quantity;

    public OrderMessage() {
    }

    public OrderMessage(String orderLocation, String orderNumber, OffsetDateTime orderDateTime, String creditCardNumber, String itemName, int price, int quantity) {
        this.orderLocation = orderLocation;
        this.orderNumber = orderNumber;
        this.orderDateTime = orderDateTime;
        this.creditCardNumber = creditCardNumber;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getOrderLocation() {
        return orderLocation;
    }

    public void setOrderLocation(String orderLocation) {
        this.orderLocation = orderLocation;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public OffsetDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(OffsetDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderMessage{" +
                "orderLocation='" + orderLocation + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", orderDateTime=" + orderDateTime +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
