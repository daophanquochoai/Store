package com.doctorhoai.monotholic_be.controller;

import com.doctorhoai.monotholic_be.dto.Account;
import com.doctorhoai.monotholic_be.dto.SignIn;
import com.doctorhoai.monotholic_be.dto.response.ApiResponse;
import com.doctorhoai.monotholic_be.dto.response.AuthResponse;
import com.doctorhoai.monotholic_be.service.inter.AuthService;
import com.doctorhoai.monotholic_be.service.inter.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createAccount(
            @RequestBody Account account
            ){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        userService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.builder()
                        .status(HttpStatus.CREATED)
                        .message("Create account success")
                        .build()
        );
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAccount(
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.getAllAccount()
        );
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(
            @RequestBody SignIn sign
            ){
        return ResponseEntity.ok(
                authService.authenticate(sign)
        );
    }
    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authService.refreshToken(request,response);
    }
}
