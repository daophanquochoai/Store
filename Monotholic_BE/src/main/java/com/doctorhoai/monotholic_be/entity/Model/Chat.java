package com.doctorhoai.monotholic_be.entity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Chat{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer chatId;
    private String message;
    private String images;
    private LocalDateTime time;
    @OneToOne
    private User user;
}
