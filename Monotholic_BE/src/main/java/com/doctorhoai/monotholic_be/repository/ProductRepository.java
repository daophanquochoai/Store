package com.doctorhoai.monotholic_be.repository;

import com.doctorhoai.monotholic_be.entity.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
