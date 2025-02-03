package com.pycampadb.kafka.api.request;

public class BasicDataFourRequest {
    private int arrayElementsCount;
    private int listElementsCount;
    private int setElementsCount;

    public int getArrayElementsCount() {
        return arrayElementsCount;
    }

    public void setArrayElementsCount(int arrayElementsCount) {
        this.arrayElementsCount = arrayElementsCount;
    }

    public int getListElementsCount() {
        return listElementsCount;
    }

    public void setListElementsCount(int listElementsCount) {
        this.listElementsCount = listElementsCount;
    }

    public int getSetElementsCount() {
        return setElementsCount;
    }

    public void setSetElementsCount(int setElementsCount) {
        this.setElementsCount = setElementsCount;
    }

    @Override
    public String toString() {
        return "BasicDataFourRequest{" +
                "arrayElementsCount=" + arrayElementsCount +
                ", listElementsCount=" + listElementsCount +
                ", setElementsCount=" + setElementsCount +
                '}';
    }
}
