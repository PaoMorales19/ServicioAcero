package com.steel.servicioacero.dto;

public class PurchaseRequest {
    private String provider;
    private specification specifications;
    private String deliveryTime;

    public PurchaseRequest(String provider, specification specifications, String deliveryTime) {
        this.provider = provider;
        this.specifications = specifications;
        this.deliveryTime = deliveryTime;
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

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                "provider='" + provider + '\'' +
                ", specifications=" + specifications +
                ", deliveryTime='" + deliveryTime + '\'' +
                '}';
    }


}
