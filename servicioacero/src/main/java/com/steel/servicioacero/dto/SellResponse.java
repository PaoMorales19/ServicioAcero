package com.steel.servicioacero.dto;

public class SellResponse {
    private String Id;
    private String message;
    public SellResponse() {
    }
    public SellResponse(String id, String message) {
        Id = id;
        this.message = message;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    
    
}
