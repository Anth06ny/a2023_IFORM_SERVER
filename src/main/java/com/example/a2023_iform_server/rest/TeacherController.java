package com.example.a2023_iform_server.rest;

import com.example.a2023_iform_server.model.bean.TeacherBean;
import com.example.a2023_iform_server.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //http://localhost:8080/teacher/add?code=56
    @GetMapping("/add")
    public TeacherBean addTeacher(Integer code) throws Exception {
        System.out.println("/add");

        return teacherService.addOrUpdateTeacher(new TeacherBean("aaaa", code));
    }

}
