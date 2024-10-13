package com.steel.servicioacero.dto;

public class PurchaseResponse {
    private String id;
    private String message;

    // Constructor vacío
    public PurchaseResponse() {
    }

    // Constructor con parámetros
    public PurchaseResponse(String id, String message) {
        this.id = id;
        this.message = message;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
