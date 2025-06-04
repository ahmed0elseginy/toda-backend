package com.toda.user.service;

import com.toda.user.error.exception.BusinessException;
import com.toda.user.model.dto.generated.DeleteUserRequest;
import com.toda.user.repository.entity.User;
import com.toda.user.repository.jpa.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.toda.user.model.enums.UserErrors.INVALID_CREDENTIALS;
import static com.toda.user.model.enums.UserErrors.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean checkUserExists(Long id) {
        return userRepository.existsById(id);
    }

    @Transactional
    @Override
    public void deleteUser(DeleteUserRequest deleteUserRequest) {
        User user = userRepository.findByEmail(deleteUserRequest.getUsername());
        if (user == null)
            throw new BusinessException(INVALID_CREDENTIALS);
        else if (!passwordEncoder.matches(deleteUserRequest.getPassword(), user.getPassword())) {
            throw new BusinessException(INVALID_CREDENTIALS);
        }
        userRepository.delete(user);
    }

}
