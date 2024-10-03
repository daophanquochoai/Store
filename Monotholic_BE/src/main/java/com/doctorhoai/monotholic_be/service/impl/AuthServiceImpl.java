package com.doctorhoai.monotholic_be.service.impl;

import com.doctorhoai.monotholic_be.dto.SignIn;
import com.doctorhoai.monotholic_be.dto.response.AuthResponse;
import com.doctorhoai.monotholic_be.entity.Model.Tokens;
import com.doctorhoai.monotholic_be.entity.Model.User;
import com.doctorhoai.monotholic_be.repository.UserRepository;
import com.doctorhoai.monotholic_be.repository.TokenRepository;
import com.doctorhoai.monotholic_be.security.jwt.JwtService;
import com.doctorhoai.monotholic_be.service.inter.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager  authenticationManager;
    @Override
    public AuthResponse authenticate(SignIn sign) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        sign.getUsername(),
                        sign.getPassword()
                )
        );
        var user = userRepository.findByEmail(sign.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("User not fond with name " + sign.getUsername())
        );
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        log.info("{} : {}", jwtToken, refreshToken);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHear =  request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if( authHear == null  || !authHear.startsWith("Bearer ")){
            return;
        }
        refreshToken = authHear.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if( userEmail != null ){
            var user = this.userRepository.findByEmail(userEmail).orElseThrow(
                    () -> new UsernameNotFoundException("User not found with email :" + userEmail)
            );
            if( jwtService.isTokenValid(refreshToken,user)){
                var accessToken = jwtService.generateToken(user);
                log.info("{} : {}", accessToken, refreshToken);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(),  authResponse);
            }
        }
    }

    private void revokeAllUserTokens(User user){
        var validUserTokens  = tokenRepository.findByUser_Email(user.getEmail());
        if( validUserTokens.isEmpty() ) return;
        validUserTokens.forEach( token -> {
            token.setIsEnabled(false);
        });
        tokenRepository.saveAll(validUserTokens);
    }
    private void saveUserToken( User user, String jwtToken ){
        var token = Tokens.builder()
                .token(jwtToken)
                .user(user)
                .isEnabled(true)
                .build();
        tokenRepository.save(token);
    }
}
