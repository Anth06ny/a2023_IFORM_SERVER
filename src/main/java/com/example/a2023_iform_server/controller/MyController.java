package com.example.a2023_iform_server.controller;

import com.example.a2023_iform_server.model.bean.StudentBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MyController {

    //http://localhost:8080/hello
    @GetMapping("/hello")
    public String testHello(Model model){
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
}
