package com.doctorhoai.monotholic_be.security.OAuth2.security;

import com.doctorhoai.monotholic_be.entity.Model.User;
import com.doctorhoai.monotholic_be.entity.OAuth2.Provider;
import com.doctorhoai.monotholic_be.exception.BaseException;
import com.doctorhoai.monotholic_be.repository.CredentialRepository;
import com.doctorhoai.monotholic_be.repository.UserRepository;
import com.doctorhoai.monotholic_be.security.OAuth2.OAuth2USerDetailFactory;
import com.doctorhoai.monotholic_be.security.OAuth2.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserDetailService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;
    private final CredentialRepository credentialRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        try{
            return checkingOAuth2User(userRequest, oAuth2User);
        } catch (BaseException e) {
            throw new RuntimeException(e);
        }
        catch ( AuthenticationException e ){
            throw e;
        }
        catch (Exception e ){
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }
    }

    private OAuth2User checkingOAuth2User( OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User ) throws BaseException {
        OAuth2UserInfo oAuth2UserInfo = OAuth2USerDetailFactory.getOAuth2UserDetail(
                oAuth2UserRequest.getClientRegistration().getRegistrationId(),
                oAuth2User.getAttributes()
        );
        if(ObjectUtils.isEmpty(oAuth2UserRequest)){
            throw new BaseException("400", "Can not found oauth2 uer from properties");
        }
        Optional<User> user = userRepository.findByEmail(oAuth2UserInfo.getEmail());
        User userNew;
        if( user.isPresent() ){
            userNew = user.get();
            if( !userNew.getProvider().toString().equals(oAuth2UserRequest.getClientRegistration().getRegistrationId()) ){
                throw new BaseException("400", "Invalid side login with " + userNew.getProvider().toString());
            }
            userNew = updateOAuth2UserDetails(userNew, oAuth2UserInfo);
        }else{
            userNew = registerNewOAuth2UserDetail(oAuth2UserRequest, oAuth2UserInfo);
        }
        List<GrantedAuthority> grand = new ArrayList<>();
        grand.add(new SimpleGrantedAuthority("USER"));
        return new OAuth2UserDetailCustom(
                userNew.getUserId(),
                userNew.getEmail(),
                grand
        );
    }
    private User updateOAuth2UserDetails(User user, OAuth2UserInfo oAuth2UserInfo ){
        user.setEmail(oAuth2UserInfo.getEmail());
        user.setImageUrl(oAuth2UserInfo.getImageUrl());
        return userRepository.save(user);
    }
    private User registerNewOAuth2UserDetail( OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo  oAuth2UserInfo ){
        User user = new User();
        user.setLastName(oAuth2UserInfo.getName());
        user.setEmail(oAuth2UserInfo.getEmail());
        user.setImageUrl(oAuth2UserInfo.getImageUrl());
        System.out.println("Oauth2 Provider : " + Provider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        user.setProvider(Provider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        return userRepository.save(user);
    }
}
