package com.doctorhoai.monotholic_be.security.config;

import com.doctorhoai.monotholic_be.security.OAuth2.security.CustomAuthenticationSucessHandler;
import com.doctorhoai.monotholic_be.security.OAuth2.security.CustomOAuth2UserDetailService;
import com.doctorhoai.monotholic_be.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomOAuth2UserDetailService customOAuth2UserDetailService;
    private final CustomAuthenticationSucessHandler customAuthenticationSucessHandler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // Vô hiệu hóa CSRF
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/user/getAll").hasRole("ADMIN")
                        .requestMatchers("/api/user/authenticate").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Chính sách không duy trì phiên
                )
                .oauth2Login(
                    oauth -> oauth.userInfoEndpoint( t -> t.userService(customOAuth2UserDetailService))
                            .successHandler(customAuthenticationSucessHandler)
                )
                .authenticationProvider(authenticationProvider) // Cung cấp cơ chế xác thực
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Thêm filter JWT
                .build();
    }
}
