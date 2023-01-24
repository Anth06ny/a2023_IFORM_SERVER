package com.example.a2023_iform_server.model.bean;

public class StudentBean {

    private String name;
    private int note;

    public StudentBean() {
    }

    public StudentBean(String name, int note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
