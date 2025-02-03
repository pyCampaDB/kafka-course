package com.pycampadb.msvc.api.request.commodity;

import java.util.List;

public class OrderRequest {
    private String orderLocation;
    private String creditCardNumber;
    private List<OrderItemRequest> items;

    public OrderRequest() {
    }

    public OrderRequest(String orderLocation, String creditCardNumber, List<OrderItemRequest> items) {
        this.orderLocation = orderLocation;
        this.creditCardNumber = creditCardNumber;
        this.items = items;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getOrderLocation() {
        return orderLocation;
    }

    public void setOrderLocation(String orderLocation) {
        this.orderLocation = orderLocation;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderLocation='" + orderLocation + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", items=" + items +
                '}';
    }
}
