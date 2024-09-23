package com.steel.servicioacero.dto;

public class PurchaseResponse {
   private String message;
    private String Id;
    public PurchaseResponse() {
    }
    public PurchaseResponse(String message, String id) {
        this.message = message;
        Id = id;
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    
    
}
