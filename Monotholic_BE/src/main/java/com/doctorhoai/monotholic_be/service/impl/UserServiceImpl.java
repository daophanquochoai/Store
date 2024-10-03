package com.doctorhoai.monotholic_be.service.impl;

import com.doctorhoai.monotholic_be.dto.Account;
import com.doctorhoai.monotholic_be.entity.Model.Credentials;
import com.doctorhoai.monotholic_be.entity.Model.User;
import com.doctorhoai.monotholic_be.repository.CredentialRepository;
import com.doctorhoai.monotholic_be.repository.UserRepository;
import com.doctorhoai.monotholic_be.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CredentialRepository credentialRepository;
    @Override
    public void createAccount(Account account) {
        User user = User.builder()
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .imageUrl(account.getImageUrl())
                .email(account.getEmail())
                .phone(account.getPhone())
                .build();
        Credentials credentials = Credentials.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .role(account.getRole())
                .isEnabled(true)
                .build();
        user.setCredentials(credentials);
        credentialRepository.save(credentials);
        userRepository.save(user);
    }

    @Override
    public List<?> getAllAccount() {
        return userRepository.findAll();
    }
}
