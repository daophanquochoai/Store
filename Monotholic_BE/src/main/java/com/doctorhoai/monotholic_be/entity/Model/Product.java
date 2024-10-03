package com.doctorhoai.monotholic_be.entity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productTitle;
    private String imageUrl;
    private Integer priceUnit;
    private Integer quantity;
    @JoinColumn(name = "categoryId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
