package com.example.a2023_iform_server.rest;

import com.example.a2023_iform_server.model.bean.StudentBean;
import com.example.a2023_iform_server.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //http://localhost:8080/student/add
    @GetMapping("/add")
    public StudentBean addStudent() throws Exception {
        System.out.println("/add");

        return studentService.create("Bobby", 18, 13L);
    }

    //http://localhost:8080/student/6
    @GetMapping("/{id}") //
    public StudentBean get(@PathVariable Long id) throws Exception {
        System.out.println("/get id=" + id);

        return studentService.getById(id);
    }

}
