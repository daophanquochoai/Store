package com.doctorhoai.monotholic_be.service.inter;

import com.doctorhoai.monotholic_be.dto.SignIn;
import com.doctorhoai.monotholic_be.dto.response.AuthResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {
    public AuthResponse authenticate(SignIn sign);
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
