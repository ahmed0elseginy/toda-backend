package com.toda.user.controller;

import com.toda.user.controller.generated.UsersController;
import com.toda.user.model.dto.generated.DeleteUserRequest;
import com.toda.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersController {
    private final UserService userService;

    @Value("${internal.api.key}")
    private String internalApiKey;

    @Override
    public ResponseEntity<Void> _checkUserExists(Long userId, @RequestHeader("x-api-key") String xApiKey) {
        System.out.println("Received x-api-key: " + xApiKey);
        System.out.println("Expected internalApiKey: " + internalApiKey);
        if (!internalApiKey.equals(xApiKey)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        boolean exists = userService.checkUserExists(userId);
        if (exists) {
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @Override
    public ResponseEntity<Void> _deleteUser(DeleteUserRequest deleteUserRequest) {
        userService.deleteUser(deleteUserRequest);
        return ResponseEntity.ok().build();
    }
}
