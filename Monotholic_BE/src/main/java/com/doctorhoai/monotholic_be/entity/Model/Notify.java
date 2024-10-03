package com.doctorhoai.monotholic_be.entity.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notify {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer notifyId;
    private String title;
    private String content;
    private LocalDateTime time;
    private Boolean isEnabled;
}
