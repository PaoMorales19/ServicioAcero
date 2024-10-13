package com.steel.servicioacero.dto;

public class SellRequest {
    private String buyer;
    private Double salePrice;
    private Specification specification;

    public SellRequest(String buyer, Double salePrice, Specification specification) {
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

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

}
