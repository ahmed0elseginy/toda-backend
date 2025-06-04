package com.toda.user.service;

import com.toda.user.error.exception.BusinessException;
import com.toda.user.model.dto.generated.UserProfileDTO;
import com.toda.user.model.dto.generated.UserProfileVTO;
import com.toda.user.repository.entity.User;
import com.toda.user.repository.jpa.UserRepository;
import com.toda.user.service.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.toda.user.model.enums.UserErrors.*;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(ProfileServiceImpl.class);

    @Override
    public UserProfileVTO getUserProfile() {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));

        return UserProfileVTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .mobileNumber(user.getMobileNumber())
                .build();
    }

    @Override
    @Transactional
    public void updateUserProfile(UserProfileDTO userProfileDTO) {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));

        user.setFirstName(userProfileDTO.getFirstName());
        user.setLastName(userProfileDTO.getLastName());
        user.setMobileNumber(userProfileDTO.getMobileNumber());

        userRepository.save(user);
        log.info("Successfully updated profile for user ID: {}", user.getId());
    }
}
