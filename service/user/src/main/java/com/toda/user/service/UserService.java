package com.toda.user.service;

import com.toda.user.model.dto.generated.DeleteUserRequest;

public interface UserService {

    boolean checkUserExists(Long id);
    void deleteUser(DeleteUserRequest deleteUserRequest);
}
