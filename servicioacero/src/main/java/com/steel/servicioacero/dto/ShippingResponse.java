package com.steel.servicioacero.dto;

public class ShippingResponse {
    private String orderId;
    private String shippingDetails;
    private String message;

    public ShippingResponse(String orderId, String shippingDetails, String message) {
        this.orderId = orderId;
        this.shippingDetails = shippingDetails;
        this.message = message;
    }

    public ShippingResponse() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(String shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
