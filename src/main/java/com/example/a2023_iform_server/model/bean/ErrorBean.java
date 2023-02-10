package com.example.a2023_iform_server.model.bean;

public class ErrorBean {
    private String message;

    public ErrorBean() {
    }

    public ErrorBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
