package com.doctorhoai.monotholic_be.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignIn {
    private String username;
    private String password;
}
