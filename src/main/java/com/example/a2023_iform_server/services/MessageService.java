package com.example.a2023_iform_server.services;

import com.example.a2023_iform_server.model.bean.MessageBean;
import com.example.a2023_iform_server.model.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public void addMessage(MessageBean toSave) throws Exception {

        //Controle des données
        if (toSave == null) {
            throw new Exception("teacher missing");
        } else if (toSave.getPseudo() == null || toSave.getPseudo().length() < 3) {
            throw new Exception("Name too short. Min 3 carateres");
        } else if (toSave.getMessage() == null || toSave.getMessage().length() < 3) {
            throw new Exception("Message too short. Min 3 carateres");
        }
        //Permet d'eviter la modification des messages
        toSave.setId(0);
        toSave.setDate(new Date().getTime());

        repository.save(toSave);
    }

    public List<MessageBean> getAllMessage() {
        return repository.findAll();
    }

    public List<MessageBean> last10Message() {
        return repository.findTop10ByOrderByDateDesc();
    }
}
