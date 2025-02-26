package com.doctorhoai.monotholic_be.security.OAuth2;

import java.util.Map;
public class GithubOAuth2 extends OAuth2UserInfo{
    public GithubOAuth2( Map<String, Object> attributes){
        super(attributes);
    }
    @Override
    public String getId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("login");
    }

    @Override
    public String getImageUrl() {
        return (String) attributes.get("avatar_url");
    }
}
