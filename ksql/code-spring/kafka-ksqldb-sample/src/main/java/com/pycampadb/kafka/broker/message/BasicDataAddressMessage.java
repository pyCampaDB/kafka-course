package com.pycampadb.kafka.broker.message;

public class BasicDataAddressMessage {
    private String streetAddress;
    private String country;
    private BasicDataLocationMessage location;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BasicDataLocationMessage getLocation() {
        return location;
    }

    public void setLocation(BasicDataLocationMessage location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "BasicDataAddressMessage{" +
                "streetAddress='" + streetAddress + '\'' +
                ", country='" + country + '\'' +
                ", location=" + location +
                '}';
    }
}
