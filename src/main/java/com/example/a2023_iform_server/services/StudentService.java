package com.example.a2023_iform_server.services;

import com.example.a2023_iform_server.model.bean.StudentBean;
import com.example.a2023_iform_server.model.repository.StudentRepository;
import com.example.a2023_iform_server.model.repository.TeacherRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private TeacherRepository teacherRepo;


    public List<StudentBean> getAll() {

        System.out.println("StudentService");


        return repository.findAll();
    }

    public List<StudentBean> findByNameAndOld(String name, Integer old) {
        if (name == null && old == null) {
            return repository.findAll();
        } else if (name == null) {
            return repository.findByNameLikeIgnoreCase(name);
        } else if (old == null) {
            return repository.findByOld(old);
        }

        return repository.findByNameLikeIgnoreCaseAndOld(name, old);
    }

    public StudentBean create(StudentBean studentBean, Long teacherId) {
        studentBean.setTeacher(teacherRepo.findById(teacherId).orElse(null));
        repository.save(studentBean);
        return studentBean;
    }

    public StudentBean create(StudentBean studentBean) {
        return create(studentBean, 0L);
    }

    public StudentBean create(String name, int old, Long teacherId) {
        return create(new StudentBean(name, old), teacherId);
    }

    public StudentBean getById(Long id) {
        if (id == null) {
            return null;
        }
        return repository.findById(id).orElse(null);
    }
}
