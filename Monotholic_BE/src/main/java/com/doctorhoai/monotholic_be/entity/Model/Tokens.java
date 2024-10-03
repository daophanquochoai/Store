package com.doctorhoai.monotholic_be.entity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Tokens {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer verificationId;
    private String token;
    private Boolean isEnabled;
    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;
}
