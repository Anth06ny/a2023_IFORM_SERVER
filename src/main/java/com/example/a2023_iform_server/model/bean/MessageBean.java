package com.example.a2023_iform_server.model.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class MessageBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pseudo, message;
    private Long date;

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

    public long getId() {
        return id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
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
