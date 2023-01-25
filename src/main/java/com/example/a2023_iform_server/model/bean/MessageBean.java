package com.example.a2023_iform_server.model.bean;

public class MessageBean {

    private String pseudo, message;

    public MessageBean() {
    }

    public MessageBean(String pseudo, String message) {
        this.pseudo = pseudo;
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "pseudo='" + pseudo + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
