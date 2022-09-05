package com.example.demo;

public class Food {
    private String foodId;
    private String foodName;
    private Double foodUnitPrice;

    public Food() {
    }

    public Food(String foodId, String foodName, Double foodUnitPrice) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodUnitPrice = foodUnitPrice;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodUnitPrice() {
        return foodUnitPrice;
    }

    public void setFoodUnitPrice(Double foodUnitPrice) {
        this.foodUnitPrice = foodUnitPrice;
    }
}
