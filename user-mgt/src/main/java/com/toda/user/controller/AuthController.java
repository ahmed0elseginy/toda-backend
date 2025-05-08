package com.toda.user.controller;

import com.toda.user.controller.generated.AuthApi;
import com.toda.user.model.dto.generated.CreateUserDTO;
import com.toda.user.model.dto.generated.LoginUserDTO;
import com.toda.user.model.dto.generated.LoginUserVTO;
import com.toda.user.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class AuthController implements AuthApi {
    private final AuthService authService;

    @Override
    public ResponseEntity<LoginUserVTO> login(LoginUserDTO loginUserDTO) {
        LoginUserVTO res = authService.login(loginUserDTO);
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<Void> registerUser(CreateUserDTO createUserDTO) {
        authService.registerUser(createUserDTO);
        return ResponseEntity.status(CREATED).build();
    }
}
