package com.pycampadb.msvc.api.response.customer.purchase;

public class PurchaseResponse {
    private String purchaseNumber;

    public PurchaseResponse(String purchaseNumber) {
        super();
        this.purchaseNumber = purchaseNumber;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    @Override
    public String toString() {
        return "PurchaseResponse{" +
                "purchaseNumber='" + purchaseNumber + '\'' +
                '}';
    }
}
