package com.doctorhoai.monotholic_be.entity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryTitle;
    private String imageUrl;
}
