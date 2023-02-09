package com.example.a2023_iform_server.model.repository;

import com.example.a2023_iform_server.model.bean.StudentBean;
import com.example.a2023_iform_server.model.bean.TeacherBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentBean, Long> {

    List<StudentBean> findByNameLikeIgnoreCaseAndOld(String name, Integer old);
    List<StudentBean> findByOld(Integer old);
    List<StudentBean> findByNameLikeIgnoreCase(String name);
}
