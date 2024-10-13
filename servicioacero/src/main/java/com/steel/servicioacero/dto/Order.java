package com.steel.servicioacero.dto;

public class Order {
    private String Id;
    private String Status;

    public Order(String id, String status) {
        Id = id;
        Status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

}
