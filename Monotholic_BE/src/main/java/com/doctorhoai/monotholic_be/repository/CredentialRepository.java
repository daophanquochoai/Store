package com.doctorhoai.monotholic_be.repository;

import com.doctorhoai.monotholic_be.entity.Model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credentials, Integer> {
}
