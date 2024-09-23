package com.steel.servicioacero.dto;

public class SellRequest {
    private String buyer;
    private float salePrice;
    private specification specifications;

    public SellRequest(String buyer, float salePrice, specification specifications) {
        this.buyer = buyer;
        this.salePrice = salePrice;
        this.specifications = specifications;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public specification getSpecifications() {
        return specifications;
    }

    public void setSpecifications(specification specifications) {
        this.specifications = specifications;
    }

    


    
}
