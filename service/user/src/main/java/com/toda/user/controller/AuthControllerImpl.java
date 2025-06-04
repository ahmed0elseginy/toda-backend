package com.toda.user.controller;

import com.toda.user.controller.generated.AuthController;
import com.toda.user.model.dto.generated.*;
import com.toda.user.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthService authService;

    @Override
    public ResponseEntity<Void> _activateUser(String username) {
        authService.activateUser(username);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> _changePassword(ChangePasswordRequest changePasswordRequest) {
        authService.changePassword(changePasswordRequest.getToken(), changePasswordRequest.getOtp(), changePasswordRequest.getNewPassword());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> _checkToken(CheckTokenRequest checkTokenRequest) {
        authService.checkToken(checkTokenRequest.getToken());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> _forgetPassword(CheckTokenRequest checkTokenRequest) {
        authService.forgetPassword(checkTokenRequest.getToken());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> _regenerateOtp(String email) {
        authService.regenerateOtp(email);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<LoginUserVTO> _login(LoginUserDTO loginUserDTO) {
        LoginUserVTO res = authService.login(loginUserDTO);
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<Void> _registerUser(CreateUserDTO createUserDTO) {
        authService.registerUser(createUserDTO);
        return ResponseEntity.status(CREATED).build();
    }
}
