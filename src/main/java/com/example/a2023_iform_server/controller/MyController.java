package com.example.a2023_iform_server.controller;

import com.example.a2023_iform_server.model.bean.StudentBean;
import com.example.a2023_iform_server.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private StudentService studentService;

    //http://localhost:8080/hello
    @GetMapping("/hello")
    public String testHello(Model model) {
        System.out.println("/hello");

        //Valeur directe
        model.addAttribute("texte", "Bonjour");
        //Objet
        model.addAttribute("studentBean", new StudentBean("Toto", 12));
        //Passer une collection
        ArrayList<StudentBean> list = new ArrayList<>();
        list.add(new StudentBean("Bobby", 17));
        list.add(new StudentBean("Tata", 14));
        model.addAttribute("studentList", list);

        //Nom du fichier HTML que l'on souhaite afficher
        return "welcome";
    }

    //http://localhost:8080/add?name=cccc&note=18
    @GetMapping("/add")
    public String add(String name, Integer note, Model model) throws Exception {
        System.out.println("/add name=" + name + " note=" + note);

        StudentBean createStudent = studentService.create(name, note, 0L);

        //Valeur directe
        model.addAttribute("texte", "Ajout de ");
        //Objet
        model.addAttribute("studentBean", createStudent);

        //Passer une collection
        model.addAttribute("studentList", studentService.getAll());

        return "welcome";
    }

    //http://localhost:8080/filter?name=Bobby&note=18
    @GetMapping("/filter")
    public String filter(Model model, String name, Integer note) {
        System.out.println("/filter name=" + name + " note=" + note);

        model.addAttribute("texte", "Recherche : name=" + name + " note=" + note);
        List<StudentBean>list =  studentService.findByNameAndOld(name, note) ;
        //on ne remplit pas le champ studentBean, et on gère dans l'HTML le check null
        model.addAttribute("studentList", list);

        return "welcome";
    }
}
