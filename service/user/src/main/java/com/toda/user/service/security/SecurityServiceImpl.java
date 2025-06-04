package com.toda.user.service.security;

import com.toda.user.error.exception.BusinessException;
import com.toda.user.repository.entity.User;
import com.toda.user.repository.jpa.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.toda.user.model.enums.UserErrors.UNAUTHORIZED;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Override
    public Boolean comparePasswords(String unHashedPassword, String hashedPassword) {
        return passwordEncoder.matches(unHashedPassword, hashedPassword);
    }
}
