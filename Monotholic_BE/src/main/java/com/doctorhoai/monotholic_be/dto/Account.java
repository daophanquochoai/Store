package com.doctorhoai.monotholic_be.dto;

import com.doctorhoai.monotholic_be.enums.ERole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String email;
    private String phone;
    private String username;
    private String password;
    private ERole role;
}
