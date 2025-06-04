package com.toda.user.controller;

import com.toda.user.controller.generated.ProfileController;
import com.toda.user.model.dto.generated.UserProfileDTO;
import com.toda.user.model.dto.generated.UserProfileVTO;
import com.toda.user.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileControllerImpl implements ProfileController {

    private final ProfileService profileService;

    @Override
    public ResponseEntity<UserProfileVTO> _getUserProfile() {
        UserProfileVTO userProfile = profileService.getUserProfile();
        return ResponseEntity.ok(userProfile);
    }

    @Override
    public ResponseEntity<Void> _updateUserProfile(UserProfileDTO userProfileDTO) {
        profileService.updateUserProfile(userProfileDTO);
        return ResponseEntity.noContent().build(); // HTTP 204
    }
}
