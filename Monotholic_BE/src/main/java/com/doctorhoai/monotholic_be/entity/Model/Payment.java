package com.doctorhoai.monotholic_be.entity.Model;

import com.doctorhoai.monotholic_be.enums.EPayment;
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
public class Payment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    @OneToOne(fetch = FetchType.LAZY)
    private Orders orders;
    private Boolean isPayed;
    private EPayment paymentStatus;
}
