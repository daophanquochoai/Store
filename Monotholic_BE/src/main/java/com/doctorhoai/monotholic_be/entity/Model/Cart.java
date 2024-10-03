package com.doctorhoai.monotholic_be.entity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer cartId;
    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;
}
