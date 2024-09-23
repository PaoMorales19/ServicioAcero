package com.steel.servicioacero.dto;

public class ShippingRequest {
    private String orderId;
    private String ShippingDetails;

    public ShippingRequest(String orderId, String shippingDetails) {
        this.orderId = orderId;
        ShippingDetails = shippingDetails;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShippingDetails() {
        return ShippingDetails;
    }

    public void setShippingDetails(String shippingDetails) {
        ShippingDetails = shippingDetails;
    }

    


    
}
