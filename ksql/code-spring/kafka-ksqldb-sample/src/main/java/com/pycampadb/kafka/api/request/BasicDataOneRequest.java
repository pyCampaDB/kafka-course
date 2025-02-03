package com.pycampadb.kafka.api.request;

import java.math.BigDecimal;

public class BasicDataOneRequest {
    private boolean myBoolean;
    private String myString;
    private String myAnotherString;
    private int myInteger;
    private long myLong;
    private float myFloat;
    private double myDouble;
    private BigDecimal myBigDecimal;

    public boolean isMyBoolean() {
        return myBoolean;
    }

    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public String getMyAnotherString() {
        return myAnotherString;
    }

    public void setMyAnotherString(String myAnotherString) {
        this.myAnotherString = myAnotherString;
    }

    public int getMyInteger() {
        return myInteger;
    }

    public void setMyInteger(int myInteger) {
        this.myInteger = myInteger;
    }

    public long getMyLong() {
        return myLong;
    }

    public void setMyLong(long myLong) {
        this.myLong = myLong;
    }

    public float getMyFloat() {
        return myFloat;
    }

    public void setMyFloat(float myFloat) {
        this.myFloat = myFloat;
    }

    public double getMyDouble() {
        return myDouble;
    }

    public void setMyDouble(double myDouble) {
        this.myDouble = myDouble;
    }

    public BigDecimal getMyBigDecimal() {
        return myBigDecimal;
    }

    public void setMyBigDecimal(BigDecimal myBigDecimal) {
        this.myBigDecimal = myBigDecimal;
    }

    @Override
    public String toString() {
        return "BasicDataOneRequest{" +
                "myBoolean=" + myBoolean +
                ", myString='" + myString + '\'' +
                ", myAnotherString='" + myAnotherString + '\'' +
                ", myInteger=" + myInteger +
                ", myLong=" + myLong +
                ", myFloat=" + myFloat +
                ", myDouble=" + myDouble +
                ", myBigDecimal=" + myBigDecimal +
                '}';
    }
}
