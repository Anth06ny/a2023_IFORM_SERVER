package com.example.a2023_iform_server.model.bean;

public class PlaneBean {
    private String name;
    private String id;

    @Override
    public String toString() {
        return "PlaneBean{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
