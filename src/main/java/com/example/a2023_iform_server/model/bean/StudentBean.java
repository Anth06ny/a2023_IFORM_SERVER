package com.example.a2023_iform_server.model.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int old;


    @ManyToOne
    @JoinColumn(name = "fk_id_teacher", referencedColumnName = "id")
    private TeacherBean teacher;


    public StudentBean() {
    }

    public StudentBean(String name, int old) {
        this.name = name;
        this.old = old;
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

    public int getOld() {
        return old;
    }

    public void setOld(int note) {
        this.old = note;
    }

    public TeacherBean getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherBean teacher) {
        this.teacher = teacher;
    }
}
