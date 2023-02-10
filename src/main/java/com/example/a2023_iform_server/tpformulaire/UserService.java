package com.example.a2023_iform_server.tpformulaire;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserBean getUserByIdSession(String idSession){
        return repository.findByIdSession(idSession);
    }

    public List<UserBean> getAll(){
        return repository.findAll();
    }

    //Si l'utilisateur n'existe aps l'insert sinon vérifie son mdp
    //Et met à jour sa session
    public UserBean checkOrInsert(UserBean userBean, HttpSession session) throws Exception {

        userBean.setName(userBean.getName().trim());

        UserBean userRegister = repository.findByNameEqualsIgnoreCase(userBean.getName());

        if (userRegister == null) {
            //insert
            userBean.setIdSession(session.getId());
            repository.save(userBean);
            return userBean;
        } else {
            //Verif de mot de passe
            if(!userRegister.getPassword().equals(userBean.getPassword())) {
                  throw new Exception("Mot de passe incorrect");
            }
            else {
                //je mets à jour son idsession
                userRegister.setIdSession(session.getId());
                repository.save(userRegister);
                return userRegister;
            }
        }
    }

    //Si l'utilisateur n'existe aps l'insert sinon vérifie son mdp
    //Et met à jour sa session
    public void checkOrInsertWithoutSession(UserBean userBean) throws Exception {

        userBean.setName(userBean.getName().trim());

        UserBean userRegister = repository.findByNameEqualsIgnoreCase(userBean.getName());

        if (userRegister == null) {
            //insert
            userBean.setIdSession(UUID.randomUUID().toString());
            repository.save(userBean);
        } else {
            //Verif de mot de passe
            if(!userRegister.getPassword().equals(userBean.getPassword())) {
                throw new Exception("Mot de passe incorrect");
            }
            else {
                //je mets à jour son idsession
                userRegister.setIdSession(UUID.randomUUID().toString());
                repository.save(userRegister);
            }
        }
    }

}
