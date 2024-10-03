package com.doctorhoai.monotholic_be.repository;

import com.doctorhoai.monotholic_be.entity.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
