package com.doctorhoai.monotholic_be.security.OAuth2.security;

import com.doctorhoai.monotholic_be.security.jwt.JwtService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSucessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtService jwtService;
    @Value("${application.security.oauth2.redirectUri}")
    private String redirectUri;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        handle(request,response,authentication);
        super.clearAuthenticationAttributes(request);
    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String target = redirectUri.isEmpty() ? determineTargetUrl(request,response,authentication) : redirectUri;
        String accessToken = jwtService.generateToken((UserDetails) authentication.getPrincipal());
        String refreshToken = jwtService.generateRefreshToken((UserDetails) authentication.getPrincipal());
        target = UriComponentsBuilder.fromUriString(target).queryParam("atoken", accessToken).queryParam("rtoken", refreshToken).build().toUriString();
        getRedirectStrategy().sendRedirect(request, response ,target);
    }
}
