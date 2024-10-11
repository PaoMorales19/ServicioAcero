package com.steel.servicioacero.dto;

public class specification {
    private String quality;
    private Integer quantity;
    private Double amount;

    public specification(String quality, Integer quantity, Double amount) {
        this.quality = quality;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
