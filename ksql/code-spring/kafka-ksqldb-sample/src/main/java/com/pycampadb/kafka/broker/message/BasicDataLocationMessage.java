package com.pycampadb.kafka.broker.message;

public class BasicDataLocationMessage {
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
        return "BasicDataLocationMessage{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
