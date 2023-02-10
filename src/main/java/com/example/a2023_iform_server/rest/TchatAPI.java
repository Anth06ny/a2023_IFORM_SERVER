package com.example.a2023_iform_server.rest;

import com.example.a2023_iform_server.model.bean.ErrorBean;
import com.example.a2023_iform_server.model.bean.MessageBean;
import com.example.a2023_iform_server.services.MessageService;
import com.example.a2023_iform_server.tpformulaire.UserBean;
import com.example.a2023_iform_server.tpformulaire.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tchat")
public class TchatAPI {


//    public TchatAPI() {
//        //jeu de données au départ
//            list.add(new MessageBean("Toto", "coucou10" ));
//            list.add(new MessageBean("Toto", "coucou11" ));
//            list.add(new MessageBean("Tata", "coucou12" ));
//            list.add(new MessageBean("Toto", "coucou13" ));
//            list.add(new MessageBean("Tata", "coucou14" ));
//            list.add(new MessageBean("Toto", "coucou33" ));
//
//    }

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    @PostMapping("/connect")
    public Object connect(@RequestBody UserBean userBean, HttpServletResponse response) {
        System.out.println("/connect");

        try {
            UserBean user = userService.checkOrInsert(userBean, httpSession);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(514);
            return new ErrorBean(e.getMessage());
        }
        return null;
    }

//    @PostMapping("/register")
//    public void register(@RequestBody UserBean userBean){
//        System.out.println("/register");
//
//
//    }


    //http://localhost:8080/tchat/saveMessage?id=pikjceapiojcapijce
    //Json Attendu : {"pseudo": "toto", "message": "coucou"}
    @PostMapping("/saveMessage")
    public void saveMessage(@RequestBody MessageBean messageBean) throws Exception {
        System.out.println("/saveMessage message:" + messageBean);

        UserBean userBean = userService.getUserByIdSession(httpSession.getId());

        messageService.addMessage(messageBean);
    }

    //http://localhost:8080/tchat/allMessages
    @GetMapping("/allMessages")
    public List<MessageBean> allMessages() {
        System.out.println("/allMessages  ");

        //Tous les messages
        // messageService.getAllMessage();

        return messageService.last10Message();
    }

    //http://localhost:8080/tchat/filter?filter=1&pseudo=toto
//    @GetMapping("/filter")
//    public ArrayList<MessageBean> filter(String filter, String pseudo) {
//        System.out.println("/filter");
//
//        //Pour avoir les 10 derniers
//        ArrayList<MessageBean> toSend = new ArrayList<>();
//        //Je parcours messages en partant de la fin et jsuqu'à en avoir 10
//        for (int i = list.size() - 1; i >= 0 && toSend.size() < 10; i--) {
//            MessageBean m = list.get(i);
//            //Est ce qu'il y a bien un message et il contient bien le filtre
//            if(filter == null || (m.getMessage() != null && m.getMessage().contains(filter))) {
//                //est ce que j'ai bien un filtre sur le pseudo (facultatif)
//                //Et sinon est ce qu'il correspond au pseudo du message
//                if(pseudo == null || pseudo.equalsIgnoreCase(m.getPseudo())){
//                    toSend.add(0, list.get(i));
//                }
//            }
//        }
//
//        return toSend;
//    }


}
