package com.steel.servicioacero.dto;

public class PurchaseRequest {
    private String provider;
    private specification specifications;
    private String deliveryTime;
    private OrderType orderType;

    public enum OrderType {
        Normal, Urgent
    }

    public PurchaseRequest(String provider, specification specifications, String deliveryTime, OrderType orderType) {
        this.provider = provider;
        this.specifications = specifications;
        this.deliveryTime = deliveryTime;
        this.orderType = orderType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public specification getSpecifications() {
        return specifications;
    }

    public void setSpecifications(specification specifications) {
        this.specifications = specifications;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

}
