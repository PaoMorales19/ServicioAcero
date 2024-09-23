package com.steel.servicioacero.dto;

public class specification {
    private String quality;
    private Integer quantity;

    public specification(String quality, int quantity) {
        this.quality = quality;
        this.quantity = quantity;
    }

    public String getQuality() {
        return quality;
    }
    public void setQuality(String quality) {
        this.quality = quality;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
