package com.doctorhoai.monotholic_be.repository;

import com.doctorhoai.monotholic_be.entity.Model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
}
