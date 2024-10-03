package com.doctorhoai.monotholic_be.service.inter;

import com.doctorhoai.monotholic_be.dto.Account;

import java.util.List;

public interface UserService {
    public void createAccount(Account account );
    public List<?> getAllAccount();
}
