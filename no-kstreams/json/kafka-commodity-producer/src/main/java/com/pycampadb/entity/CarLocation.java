package com.pycampadb.entity;

public class CarLocation {
    private String id;
    private long timestamp;
    private Integer distance;

    public CarLocation(String id, long timestamp, Integer distance) {
        this.id = id;
        this.timestamp = timestamp;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
