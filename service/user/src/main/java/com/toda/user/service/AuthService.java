package com.toda.user.service;


import com.toda.user.model.dto.generated.CreateUserDTO;
import com.toda.user.model.dto.generated.LoginUserDTO;
import com.toda.user.model.dto.generated.LoginUserVTO;

public interface AuthService {

    void registerUser(CreateUserDTO dto);

    LoginUserVTO login(LoginUserDTO dto);

    void activateUser(String username);
    void checkToken(String token);
    void forgetPassword(String token);
    void changePassword(String token, String otp, String newPassword);
    void regenerateOtp(String email);
}
