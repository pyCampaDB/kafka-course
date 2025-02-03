package com.pycampadb.msvc.broker.message.customer.purchase;

public class CustomerPurchaseMobileMessage {
    public static class Location {
        private double latitude;
        private double longitude;

        public Location(double latitude, double longitude) {
            super();
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "latitude=" + latitude +
                    ", longitude=" + longitude +
                    '}';
        }
    }

    private String purchaseNumber;
    private int purchaseAmount;
    private String mobileAppVersion;
    private String operatingSystem;
    private Location location;

    public CustomerPurchaseMobileMessage() {
    }

    public CustomerPurchaseMobileMessage(String purchaseNumber, int purchaseAmount, String mobileAppVersion, String operatingSystem, Location location) {
        super();
        this.purchaseNumber = purchaseNumber;
        this.purchaseAmount = purchaseAmount;
        this.mobileAppVersion = mobileAppVersion;
        this.operatingSystem = operatingSystem;
        this.location = location;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getMobileAppVersion() {
        return mobileAppVersion;
    }

    public void setMobileAppVersion(String mobileAppVersion) {
        this.mobileAppVersion = mobileAppVersion;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CustomerPurchaseMobileMessage{" +
                "purchaseNumber='" + purchaseNumber + '\'' +
                ", purchaseAmount=" + purchaseAmount +
                ", mobileAppVersion='" + mobileAppVersion + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", location=" + location +
                '}';
    }
}
