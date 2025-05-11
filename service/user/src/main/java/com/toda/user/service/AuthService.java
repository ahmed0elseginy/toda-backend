package com.toda.user.service;


import com.toda.user.model.dto.generated.CreateUserDTO;
import com.toda.user.model.dto.generated.LoginUserDTO;
import com.toda.user.model.dto.generated.LoginUserVTO;

public interface AuthService {

    void registerUser(CreateUserDTO dto);

    LoginUserVTO login(LoginUserDTO dto);
}
