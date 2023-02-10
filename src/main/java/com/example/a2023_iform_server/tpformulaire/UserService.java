package com.example.a2023_iform_server.tpformulaire;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    //Si l'utilisateur n'existe aps l'insert sinon vérifie son mdp
    //Et met à jour sa session
    public void checkOrInsert(UserBean userBean, HttpSession session) throws Exception {

        userBean.setName(userBean.getName().trim());

        UserBean userRegister = repository.findByNameEqualsIgnoreCase(userBean.getName());

        if (userRegister == null) {
            //insert
            userBean.setIdSession(session.getId());
            repository.save(userBean);
        } else {
            //Verif de mot de passe
            if(!userRegister.getPassword().equals(userBean.getPassword())) {
                  throw new Exception("Mot de passe incorrect");
            }
            else {
                //je mets à jour son idsession
                userRegister.setIdSession(session.getId());
                repository.save(userRegister);
            }
        }
    }

}
