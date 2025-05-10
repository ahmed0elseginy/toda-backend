package com.toda.user.service;

import com.toda.user.error.exception.BusinessException;
import com.toda.user.model.dto.generated.CreateUserDTO;
import com.toda.user.model.dto.generated.LoginUserDTO;
import com.toda.user.model.dto.generated.LoginUserVTO;
import com.toda.user.repository.entity.Role;
import com.toda.user.repository.entity.User;
import com.toda.user.repository.entity.UserRole;
import com.toda.user.repository.jpa.RoleRepository;
import com.toda.user.repository.jpa.UserRepository;
import com.toda.user.repository.jpa.UserRoleRepository;
import com.toda.user.service.security.JWTService;
import com.toda.user.service.security.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.toda.user.model.enums.UserErrors.*;
import static com.toda.user.model.enums.UserRoles.MEMBER;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JWTService jwtService;
    private final SecurityService securityService;


    @Override
    public void registerUser(CreateUserDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()) != null) {
            throw new BusinessException(EMAIL_ALREADY_EXIST);
        }

        Role role = roleRepository.findById(MEMBER.getId())
                .orElseThrow(() -> new BusinessException(ROLE_NOT_FOUND));

        User newUser = User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .mobileNumber(dto.getMobileNumber())
                .password(passwordEncoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .createdOn(new Date())
                .enabled(true)
                .build();

        // Save the user to get the generated ID
        User savedUser = userRepository.save(newUser);

        UserRole userRole = UserRole.builder()
                .userId(savedUser.getId())
                .role(role)
                .createdOn(new Date())
                .build();

        userRoleRepository.save(userRole);
    }

    @Override
    public LoginUserVTO login(LoginUserDTO dto) {
        try {
            User user = userRepository.findByEmail(dto.getUsername());
            System.out.println(dto.getPassword());
            if (user == null)
                throw new BusinessException(INVALID_CREDENTIALS);
            else {
                boolean isPasswordMatch = securityService.comparePasswords(dto.getPassword(), user.getPassword());
                System.out.println(isPasswordMatch);
                System.out.println(dto.getPassword() + "   " + user.getPassword());
                if (!isPasswordMatch)
                    throw new BusinessException(INVALID_CREDENTIALS);
            }
            List<UserRole> roles = userRoleRepository.findAllByUserId(user.getId());

            String token = jwtService.generateToken(user,roles);

            return LoginUserVTO.builder()
                    .token(token)
                    .build();
        } catch (AuthenticationException e) {
            throw new BusinessException(INVALID_CREDENTIALS);
        }
    }


//    @Override
//    public LoginUserVTO login(LoginUserDTO dto) {
//
//        User user = userRepository.findByEmail(dto.getUsername());
//        if (user == null)
//            throw new BusinessException(INVALID_CREDENTIALS);
//
//        else {
//            boolean isPasswordMatch = securityService.comparePasswords(dto.getPassword(), user.getPassword());
//            if (!isPasswordMatch)
//                throw new BusinessException(INVALID_CREDENTIALS);
//        }
//        UserPrincipal userPrincipal;
//
//
//        List<UserRole> roles = userRoleRepository.findAllByUserId(user.getId());
//        List<String> roleNames = roles.stream()
//                .map(userRole -> userRole.getRole().getTitleEn())
//                .toList();
//
//        String token = jwtService.generateToken(userPrincipal);
//
//        Authentication authentication = authManager.authenticate(
//                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
//
//        if (authentication.isAuthenticated()) {
//
//            UserPrincipal userPr = (UserPrincipal) authentication.getPrincipal();
//
//            return LoginUserVTO.builder()
//                    .token(jwtService.generateToken(userPr.getUser()))
//                    .build();
//        }
//
//        return LoginUserVTO.builder()
//                .token("NULL")
//                .build();
//    }

}
