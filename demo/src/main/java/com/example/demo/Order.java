package com.example.demo;

import java.sql.Timestamp;

public class Order extends Food{
    private Integer orderId;
    private Integer customerId;
    private Integer orderQuantity;
    private Timestamp orderDateTime;
    private Integer orderStatus;

    public Order() {
    }

    public Order(Integer customerId, Integer orderQuantity, Timestamp orderDateTime, Integer orderStatus) {
        this.customerId = customerId;
        this.orderQuantity = orderQuantity;
        this.orderDateTime = orderDateTime;
        this.orderStatus = orderStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Timestamp getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Timestamp orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
