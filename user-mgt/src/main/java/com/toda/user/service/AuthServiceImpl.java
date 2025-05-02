package com.toda.user.service;

import com.toda.user.error.exception.BusinessException;
import com.toda.user.model.dto.generated.CreateUserDTO;
import com.toda.user.model.dto.generated.LoginUserDTO;
import com.toda.user.model.dto.generated.LoginUserVTO;
import com.toda.user.repository.entity.Role;
import com.toda.user.repository.entity.User;
import com.toda.user.repository.jpa.RoleRepository;
import com.toda.user.repository.jpa.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.toda.user.model.enums.UserErrors.EMAIL_ALREADY_EXIST;
import static com.toda.user.model.enums.UserErrors.ROLE_NOT_FOUND;
import static com.toda.user.model.enums.UserRoles.MEMBER;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public void registerUser(CreateUserDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        if (user != null)
            throw new BusinessException(EMAIL_ALREADY_EXIST);
        Role role = roleRepository.findById(MEMBER.getId())
                .orElseThrow(() -> new BusinessException(ROLE_NOT_FOUND));

        User newUser = User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .mobileNumber(dto.getMobileNumber())
                .password(dto.getPassword())
                .email(dto.getEmail())
//                .role(role)
                .build();
        userRepository.save(newUser);
    }

    @Override
    public LoginUserVTO login(LoginUserDTO dto) {
        return null;
    }
}
