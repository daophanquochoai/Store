package com.doctorhoai.monotholic_be.security.OAuth2;
import com.doctorhoai.monotholic_be.entity.OAuth2.Provider;
import com.doctorhoai.monotholic_be.exception.BaseException;

import java.util.Map;

public class OAuth2USerDetailFactory {
    public static OAuth2UserInfo getOAuth2UserDetail( String registerId, Map<String, Object> attributes) throws BaseException {
        if( registerId.equals(Provider.facebook.name())){
            return new FacebookOAuth2((attributes));
        }else if( registerId.equals(Provider.github.name())){
            return new GithubOAuth2(attributes);
        }else{
            throw new BaseException("400", "Sorry! Login with " + registerId + " is not supported");
        }
    }
}
