package com.example.a2023_iform_server.controller;

import com.example.a2023_iform_server.model.bean.StudentBean;
import com.example.a2023_iform_server.services.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private StudentService studentService;

    /* -------------------------------- */
    // Exo formulaire
    /* -------------------------------- */
    //http://localhost:8080/form
    @GetMapping("/form")
    public String showForm(StudentBean studentBean) {
        System.out.println("/form");
        //Lance studentForm.html
        return "studentForm";
    }

    @PostMapping("/formSubmit")
    public String formResponse(StudentBean studentBean, Model model, RedirectAttributes redirect) {
        System.out.println("L'élève créé : " + studentBean.getName() + " " + studentBean.getOld());

        try {
            if (studentBean.getName().trim().length() == 0) {
                throw new Exception("Il faut un nom");
            }
            studentService.create(studentBean);

            //Lance studentFormResult.html
            return "redirect:listStudent";
        } catch (Exception e) {
            e.printStackTrace();
            redirect.addFlashAttribute("errorMessage", e.getMessage());

            //redirectuion sur une url
            return "redirect:form";
        }
    }

    @GetMapping("/listStudent")
    public String listStudent(Model model) {
        System.out.println("/listStudent");

        model.addAttribute("studentList", studentService.getAll());

        //Lance studentFormResult.html
        return "studentFormResult";
    }
    /* -------------------------------- */
    // Exo Site
    /* -------------------------------- */

    //http://localhost:8080/hello
    @GetMapping("/hello")
    public String testHello(Model model) throws Exception {
        System.out.println("/hello ");

        //Valeur directe
        model.addAttribute("texte", "Bonjour");
        //Objet
        model.addAttribute("studentBean", new StudentBean("Toto", 12));

//        //Passer une collection
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
        List<StudentBean> list = studentService.findByNameAndOld(name, note);
        //on ne remplit pas le champ studentBean, et on gère dans l'HTML le check null
        model.addAttribute("studentList", list);

        return "welcome";
    }
}
