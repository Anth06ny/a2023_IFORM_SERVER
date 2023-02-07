package com.example.a2023_iform_server.services;

import com.example.a2023_iform_server.model.bean.StudentBean;
import com.example.a2023_iform_server.model.repository.StudentRepository;
import com.example.a2023_iform_server.model.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private TeacherRepository teacherRepo;

    public StudentBean create(String name, int old, Long teacherId) throws Exception {
        StudentBean studentBean = new StudentBean(name, old);

        studentBean.setTeacher(teacherRepo.findById(teacherId).orElse(null));

        repository.save(studentBean);

        return studentBean;
    }

    public StudentBean getById(Long id) {
        if (id == null) {
            return null;
        }
        return repository.findById(id).orElse(null);
    }
}
