package com.toda.user.service;

import com.toda.user.model.dto.generated.UserProfileDTO;
import com.toda.user.model.dto.generated.UserProfileVTO;

public interface ProfileService {
    UserProfileVTO getUserProfile();
    void updateUserProfile(UserProfileDTO userProfileDTO);
}
