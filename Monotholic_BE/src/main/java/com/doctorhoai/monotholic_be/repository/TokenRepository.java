package com.doctorhoai.monotholic_be.repository;

import com.doctorhoai.monotholic_be.entity.Model.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Tokens, Integer> {
     Optional<Tokens> findByToken(String token);
     List<Tokens> findByUser_Email(String email);

}
