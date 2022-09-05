package com.example.demo;

public class FoodOrder {
    private Integer foodOrderId;
    private String foodId;
    private Integer orderId;

    public FoodOrder() {
    }

    public FoodOrder(String foodId, Integer orderId) {
        this.foodId = foodId;
        this.orderId = orderId;
    }

    public Integer getFoodOrderId() {
        return foodOrderId;
    }

    public void setFoodOrderId(Integer foodOrderId) {
        this.foodOrderId = foodOrderId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
