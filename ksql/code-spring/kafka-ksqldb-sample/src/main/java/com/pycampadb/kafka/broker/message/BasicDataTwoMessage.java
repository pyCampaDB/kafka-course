package com.pycampadb.kafka.broker.message;

public class BasicDataTwoMessage {
    private long myEpochDay;
    private long myMillisOfDay;
    private long myEpochMillis;

    public long getMyEpochDay() {
        return myEpochDay;
    }

    public void setMyEpochDay(long myEpochDay) {
        this.myEpochDay = myEpochDay;
    }

    public long getMyMillisOfDay() {
        return myMillisOfDay;
    }

    public void setMyMillisOfDay(long myMillisOfDay) {
        this.myMillisOfDay = myMillisOfDay;
    }

    public long getMyEpochMillis() {
        return myEpochMillis;
    }

    public void setMyEpochMillis(long myEpochMillis) {
        this.myEpochMillis = myEpochMillis;
    }

    @Override
    public String toString() {
        return "BasicDataTwoMessage{" +
                "myEpochDay=" + myEpochDay +
                ", myMillisOfDay=" + myMillisOfDay +
                ", myEpochMillis=" + myEpochMillis +
                '}';
    }
}
