package com.example.a2023_iform_server.services;

import com.example.a2023_iform_server.model.bean.TeacherBean;
import com.example.a2023_iform_server.model.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public TeacherBean addOrUpdateTeacher(TeacherBean toSave) throws Exception {

        //Controle des données
        if (toSave == null) {
            throw new Exception("teacher missing");
        } else if (toSave.getName() == null || toSave.getName().length() == 0) {
            throw new Exception("Name missing");
        } else if (toSave.getCode() == null || toSave.getCode() < 1 || toSave.getCode() > 100) {
            throw new Exception("Code incorrecte, il doit être contenu entre 1 et 100");
        }

        //Si on a le même code on modifie
        TeacherBean fromBase = repository.findByCode(toSave.getCode());
        if (fromBase != null) {
            //Si ce code est déjà en base
            toSave.setId(fromBase.getId());
        }
        repository.save(toSave);
        return toSave;
    }
}
