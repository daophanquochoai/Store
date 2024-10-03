package com.doctorhoai.monotholic_be.dto.response;

import com.doctorhoai.monotholic_be.dto.Account;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude( JsonInclude.Include.NON_NULL )
@Builder
public class ApiResponse {
    private HttpStatus status;
    private String message;
    private String accessToken;
    private String refreshToken;
}
