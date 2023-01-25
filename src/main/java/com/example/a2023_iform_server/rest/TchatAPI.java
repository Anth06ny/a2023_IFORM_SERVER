package com.example.a2023_iform_server.rest;

import com.example.a2023_iform_server.model.bean.MessageBean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("tchat")
public class TchatAPI {

    ArrayList<MessageBean> list = new ArrayList<>();

    public TchatAPI() {
        //jeu de données au départ
            list.add(new MessageBean("Toto", "coucou10" ));
            list.add(new MessageBean("Toto", "coucou11" ));
            list.add(new MessageBean("Tata", "coucou12" ));
            list.add(new MessageBean("Toto", "coucou13" ));
            list.add(new MessageBean("Tata", "coucou14" ));
            list.add(new MessageBean("Toto", "coucou33" ));

    }


    //http://localhost:8080/tchat/saveMessage
    //Json Attendu : {"pseudo": "toto", "message": "coucou"}
    @PostMapping("/saveMessage")
    public void saveMessage(@RequestBody MessageBean messageBean) {
        System.out.println("/saveMessage message:" + messageBean);
        list.add(messageBean);

    }

    //http://localhost:8080/tchat/allMessages
    @GetMapping("/allMessages")
    public ArrayList<MessageBean> allMessages() {
        System.out.println("/allMessages  ");

        //Pour avoir les 10 derniers
        ArrayList<MessageBean> toSend = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0 && toSend.size() < 10; i--) {
            toSend.add(0, list.get(i));
        }

        return toSend;
    }

    //http://localhost:8080/tchat/filter?filter=1&pseudo=toto
    @GetMapping("/filter")
    public ArrayList<MessageBean> filter(String filter, String pseudo) {
        System.out.println("/filter");

        //Pour avoir les 10 derniers
        ArrayList<MessageBean> toSend = new ArrayList<>();
        //Je parcours messages en partant de la fin et jsuqu'à en avoir 10
        for (int i = list.size() - 1; i >= 0 && toSend.size() < 10; i--) {
            MessageBean m = list.get(i);
            //Est ce qu'il y a bien un message et il contient bien le filtre
            if(filter == null || (m.getMessage() != null && m.getMessage().contains(filter))) {
                //est ce que j'ai bien un filtre sur le pseudo (facultatif)
                //Et sinon est ce qu'il correspond au pseudo du message
                if(pseudo == null || pseudo.equalsIgnoreCase(m.getPseudo())){
                    toSend.add(0, list.get(i));
                }
            }
        }

        return toSend;
    }



}
