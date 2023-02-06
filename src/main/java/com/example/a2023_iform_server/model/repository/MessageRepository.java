package com.example.a2023_iform_server.model.repository;

import com.example.a2023_iform_server.model.bean.MessageBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageBean, Long> {

    List<MessageBean> findTop10ByOrderByDateDesc();
}
