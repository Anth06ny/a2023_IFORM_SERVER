package com.example.a2023_iform_server.model.bean;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
public class TeachersBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "student_teachers",
            //Clé étrangère représentant cette classe
            joinColumns = @JoinColumn(name = "id_teacher"),
            //Clé étrangère représentant l'autre classe
            inverseJoinColumns = @JoinColumn(name = "id_student")
    )
    private List<StudentBean> students = new ArrayList<>();

    public TeachersBean() {
    }

    public TeachersBean(long id) {
        this.id = id;
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

    public List<StudentBean> getStudents() {
        return students;
    }


    public void setStudents(ArrayList<StudentBean> students) {
        this.students = students;
    }
}
