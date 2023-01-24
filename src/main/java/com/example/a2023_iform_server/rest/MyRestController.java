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
    public int max(Integer p1, Integer p2) {
        System.out.println("/max p1=#" + p1 + "# p2=" + p2);

        if(p1 == null){
             return p2;
        }
        else if(p2 == null){
             return p1;
        }

        return Math.max(p1,p2);
    }

//    //http://localhost:8080/max?p1=5&p2=6
//    @GetMapping("/max")
//    public int max(String p1, String p2) {
//        System.out.println("/max p1=#" + p1 + "# p2=" + p2);
//
//        Integer p1Int = null;
//        Integer p2Int = null;
//        try {
//            p1Int = Integer.parseInt(p1);
//        } catch (Exception e) {
//        }
//
//        try {
//            p2Int = Integer.parseInt(p2);
//        } catch (Exception e) {
//        }
//
//        if (p1Int == null) {
//            return p2Int;
//        } else if (p2Int == null) {
//            return p1Int;
//        }
//
//        return Math.max(p1Int, p2Int);
//    }


}
