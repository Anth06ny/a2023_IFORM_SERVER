package com.example.a2023_iform_server.model.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class TeacherBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Integer code;

    public TeacherBean() {
    }

    public TeacherBean(long id) {
        this.id = id;
    }

    public TeacherBean(long id, String name, Integer code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public TeacherBean(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
