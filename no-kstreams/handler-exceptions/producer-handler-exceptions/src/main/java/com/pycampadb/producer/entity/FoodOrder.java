package com.pycampadb.producer.entity;

public class FoodOrder {
    private int amount;
    private String foodName;

    public FoodOrder(int amount, String foodName) {
        this.amount = amount;
        this.foodName = foodName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
