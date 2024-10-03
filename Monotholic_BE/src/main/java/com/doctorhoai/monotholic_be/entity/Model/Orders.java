package com.doctorhoai.monotholic_be.entity.Model;

import com.doctorhoai.monotholic_be.enums.EOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @JoinColumn(name = "cartId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;
    @JoinColumn(name = "orderItem")
    @OneToMany( fetch = FetchType.LAZY)
    private List<OrderItem> orderItem;
    private LocalDateTime orderDate;
    private String orderDesc;
    private Integer orderFee;
    private EOrder orderStatus;
}
