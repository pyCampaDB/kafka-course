package com.pycampadb.msvc.broker.message;

public class CustomerPurchaseWebMessage {
    private String purchaseNumber;
    private int purhcaseAmount;
    private String browser;
    private String operatingSystem;

    public CustomerPurchaseWebMessage() {
    }

    public CustomerPurchaseWebMessage(String purchaseNumber, int purhcaseAmount, String browser, String operatingSystem) {
        super();
        this.purchaseNumber = purchaseNumber;
        this.purhcaseAmount = purhcaseAmount;
        this.browser = browser;
        this.operatingSystem = operatingSystem;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public int getPurhcaseAmount() {
        return purhcaseAmount;
    }

    public void setPurhcaseAmount(int purhcaseAmount) {
        this.purhcaseAmount = purhcaseAmount;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "CustomerPurchaseWebMessage{" +
                "purchaseNumber='" + purchaseNumber + '\'' +
                ", purhcaseAmount=" + purhcaseAmount +
                ", browser='" + browser + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}
