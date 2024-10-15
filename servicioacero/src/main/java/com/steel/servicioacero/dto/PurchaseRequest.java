package com.steel.servicioacero.dto;

public class PurchaseRequest {
    
    private String provider;
    private Specification specification;
    private String deliveryTime;
    private OrderType orderType;

    public enum OrderType {
        Normal, Urgent
    }

    public PurchaseRequest() {
    }

    public PurchaseRequest(String provider, Specification specification, String deliveryTime, OrderType orderType) {
        this.provider = provider;
        this.specification = specification;
        this.deliveryTime = deliveryTime;
        this.orderType = orderType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
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
