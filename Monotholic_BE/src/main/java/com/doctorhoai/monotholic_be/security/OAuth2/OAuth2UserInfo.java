package com.doctorhoai.monotholic_be.security.OAuth2;

import lombok.Data;

import java.util.Map;

@Data
public abstract class OAuth2UserInfo {
    protected Map<String, Object> attributes;
    public OAuth2UserInfo( Map<String, Object> attributes ){
        this.attributes = attributes;
    }
    public abstract String getId();
    public abstract String getName();
    public abstract String getEmail();
    public abstract String getImageUrl();
}
