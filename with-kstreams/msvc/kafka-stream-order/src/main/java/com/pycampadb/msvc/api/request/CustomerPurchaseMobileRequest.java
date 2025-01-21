package com.pycampadb.msvc.api.request;

public class CustomerPurchaseMobileRequest {
    public static class Location{
        private double latitude;
        private double longitude;

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

    private int purchaseAmount;
    private String mobileAppVersion;
    private String operatingSystem;
    private Location location;

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
        return "CustomerPurchaseMobileRequest{" +
                "purchaseAmount=" + purchaseAmount +
                ", mobileAppVersion='" + mobileAppVersion + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", location=" + location +
                '}';
    }
}
