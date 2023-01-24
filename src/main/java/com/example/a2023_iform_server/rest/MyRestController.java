package com.example.a2023_iform_server.rest;

import com.example.a2023_iform_server.model.bean.StudentBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    //http://localhost:8080/test
    @GetMapping("/test")
    public String helloworld() {
        System.out.println("/test");

        return "helloworld";
    }

    //http://localhost:8080/getStudent
    @GetMapping("/getStudent")
    public StudentBean getStudent() {
        System.out.println("/getStudent");

        return new StudentBean("Toto", 12);
    }

    //http://localhost:8080/createStudent?nom=bob&note=12
    @GetMapping("/createStudent")
    public StudentBean createStudent(String nom, int note) throws Exception {
        System.out.println("/createStudent nom=#" + nom + "# note=" + note);

        return new StudentBean(nom, note);
    }

    //http://localhost:8080/max?p1=5&p2=6
    @GetMapping("/max")
    public int max(int p1, int p2) {
        System.out.println("/max p1=#" + p1 + "# p2=" + p2);

        return Math.max(p1,p2);
    }


}
