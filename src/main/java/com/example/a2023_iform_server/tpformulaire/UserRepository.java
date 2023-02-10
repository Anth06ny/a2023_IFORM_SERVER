package com.example.a2023_iform_server.tpformulaire;

import com.example.a2023_iform_server.model.bean.TeacherBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Long> {
    UserBean findByNameEqualsIgnoreCase(String name);
    UserBean findByIdSession(String idSession);

}
