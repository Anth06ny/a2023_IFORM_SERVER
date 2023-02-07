package com.example.a2023_iform_server.services;

import com.example.a2023_iform_server.model.bean.TeacherBean;
import com.example.a2023_iform_server.model.bean.TeachersBean;
import com.example.a2023_iform_server.model.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeachersService {

    @Autowired
    private TeachersRepository repository;

    public TeachersBean getById(Long id) {
        if (id == null) {
            return null;
        }

        return repository.findById(id).orElse(null);
    }


}
