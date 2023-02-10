package com.example.a2023_iform_server.tpformulaire;

import com.example.a2023_iform_server.model.bean.StudentBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    //http://localhost:8080/user/login
    @GetMapping("/login")
    public String login(UserBean userBean) {
        System.out.println("/login");

        //Lance studentForm.html
        return "tpformulaire/login";
    }

    @PostMapping("/loginSubmit")
    public String loginSubmit(UserBean userBean, RedirectAttributes redirect) {
        System.out.println("/loginSubmit : name=" + userBean.getName() + " password=" + userBean.getPassword());

        try {
            //insert ou verif
            userService.checkOrInsert(userBean, httpSession);

            //Lance studentFormResult.html
            return "redirect:/user/userregister";
        } catch (Exception e) {
            e.printStackTrace();
            redirect.addFlashAttribute("errorMessage", e.getMessage());

            //redirectuion sur une url
            return "redirect:/user/login";
        }
    }

    //http://localhost:8080/user/userregister
    @GetMapping("/userregister")
    public String userregister () {
        System.out.println("/userregister");

        //Lance studentForm.html
        return "tpformulaire/userregister";
    }


}
