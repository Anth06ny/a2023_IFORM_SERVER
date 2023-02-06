package com.example.a2023_iform_server.model.repository;

import com.example.a2023_iform_server.model.bean.TeacherBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherBean, Long> {
    TeacherBean findByCode(Integer code);
}
