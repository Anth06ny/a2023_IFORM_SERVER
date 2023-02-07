package com.example.a2023_iform_server.rest;

import com.example.a2023_iform_server.model.bean.TeachersBean;
import com.example.a2023_iform_server.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Relation N..N
@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    //http://localhost:8080/teachers/1
    @GetMapping("/{id}") //
    public TeachersBean get(@PathVariable Long id) {
        System.out.println("/get id=" + id);

        return teachersService.getById(id);
    }

}
