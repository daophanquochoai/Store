package com.doctorhoai.monotholic_be.security.OAuth2.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

import java.util.List;
import java.util.Map;

@Data
public class OAuth2UserDetailCustom implements OAuth2User, UserDetails {
    private Integer id;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private Map<String, Object> attributes;
    public boolean isAccountNonExpired;
    public boolean isAccountNonLocked;
    public boolean isCredentialsNonExpired;
    public boolean isEnabled;

    public OAuth2UserDetailCustom(Integer id, String username, List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.authorities = authorities;
    }

    private Integer getId(){
        return id;
    }
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return username;
    }
}
