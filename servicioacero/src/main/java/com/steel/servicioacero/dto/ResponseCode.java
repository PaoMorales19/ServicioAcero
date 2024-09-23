package com.steel.servicioacero.dto;

public class ResponseCode {
    private Integer Code;
    private String Message;
    public ResponseCode() {
        
    }
    public ResponseCode(Integer code, String message) {
        Code = code;
        Message = message;
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    
    
}
