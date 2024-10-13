package com.steel.servicioacero.dto;

public class SellRequest {
    private String buyer;
    private float salePrice;
    private Specification specification;

    public SellRequest(String buyer, float salePrice, Specification specification) {
        this.buyer = buyer;
        this.salePrice = salePrice;
        this.specification = specification;
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

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    


    
}
