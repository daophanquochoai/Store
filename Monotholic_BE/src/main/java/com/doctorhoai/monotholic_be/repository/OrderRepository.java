package com.doctorhoai.monotholic_be.repository;

import com.doctorhoai.monotholic_be.entity.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
