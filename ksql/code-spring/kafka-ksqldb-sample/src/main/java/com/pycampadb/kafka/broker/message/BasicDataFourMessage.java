package com.pycampadb.kafka.broker.message;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BasicDataFourMessage {
    private String[] myStringArray;
    private List<Integer> myIntegerList;
    private Set<Double> myDoubleSet;

    public String[] getMyStringArray() {
        return myStringArray;
    }

    public void setMyStringArray(String[] myStringArray) {
        this.myStringArray = myStringArray;
    }

    public Set<Double> getMyDoubleSet() {
        return myDoubleSet;
    }

    public void setMyDoubleSet(Set<Double> myDoubleSet) {
        this.myDoubleSet = myDoubleSet;
    }

    public List<Integer> getMyIntegerList() {
        return myIntegerList;
    }

    public void setMyIntegerList(List<Integer> myIntegerList) {
        this.myIntegerList = myIntegerList;
    }

    @Override
    public String toString() {
        return "BasicDataFourMessage{" +
                "myStringArray=" + Arrays.toString(myStringArray) +
                ", myIntegerList=" + myIntegerList +
                ", myDoubleSet=" + myDoubleSet +
                '}';
    }
}
