package com.example.a2023_iform_server.rest;

import com.example.a2023_iform_server.model.bean.StudentBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    int compteur = 0;
    private StudentBean saveStudent = null;

    /* -------------------------------- */
    // EXO POST
    /* -------------------------------- */

    //http://localhost:8080/increment
//Json Attendu : {"name": "toto", "note": 12}
    @PostMapping("/increment")
    public StudentBean increment(@RequestBody StudentBean student) {
        System.out.println("/increment : " + student.getName() + " : " + student.getNote());

        student.setNote(student.getNote() +1);

        return student;
    }

    //http://localhost:8080/receiveStudent
//Json Attendu : {"name": "toto", "note": 12}
    @PostMapping("/receiveStudent")
    public void receiveStudent(@RequestBody StudentBean student) {
        System.out.println("/receiveStudent : " + student.getName() + " : " + student.getNote());

        //traitement, mettre en base…
        //Retourner d'autres données
    }

    /* -------------------------------- */
    // Mini Projet SaveStudent
    /* -------------------------------- */

    //http://localhost:8080/saveStudent?nom=toto&note=12
    @GetMapping("/saveStudent")
    public void saveStudent(String nom, @RequestParam(defaultValue = "0") Integer note) {
        System.out.println("/saveStudent nom=#" + nom + "# note=" + note);

        if (nom == null) {
            saveStudent = null;
        } else {
            saveStudent = new StudentBean(nom, note);
        }
    }

    //http://localhost:8080/loadStudent
    @GetMapping("/loadStudent")
    public StudentBean loadStudent() {
        System.out.println("/loadStudent");

        return saveStudent;
    }

    /* -------------------------------- */
    // Exo GET
    /* -------------------------------- */

    //http://localhost:8080/test
    @GetMapping("/test")
    public String helloworld() {
        System.out.println("/test");
        compteur++;
        return "helloworld +" + compteur;
    }


    //http://localhost:8080/boulangerie?nbCroissant=3&nbSandwich=1
    @GetMapping("/boulangerie")
    public double boulangerie(@RequestParam(defaultValue = "0") int nbCroissant, @RequestParam(defaultValue = "0") int nbSandwich) {
        System.out.println("/boulangerie nbCroissant=#" + nbCroissant + "# nbSandwich=" + nbSandwich);

        return nbCroissant * 0.95 + nbSandwich * 4;
    }


    //http://localhost:8080/getStudent
    @GetMapping("/getStudent")
    public StudentBean getStudent() {
        System.out.println("/getStudent");

        return new StudentBean("Toto", 12);
    }

    //http://localhost:8080/createStudent?nom=bob&note=12
    //http://86.73.100.219:8080/createStudent?nom=bob&note=12
    @GetMapping("/createStudent")
    public StudentBean createStudent(String nom, int note) throws Exception {
        System.out.println("/createStudent nom=#" + nom + "# note=" + note);

        return new StudentBean(nom, note);
    }

    //http://localhost:8080/max?p1=5&p2=6
    @GetMapping("/max")
    public int max(Integer p1, Integer p2) {
        System.out.println("/max p1=#" + p1 + "# p2=" + p2);

        if (p1 == null) {
            return p2;
        } else if (p2 == null) {
            return p1;
        }

        return Math.max(p1, p2);
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
