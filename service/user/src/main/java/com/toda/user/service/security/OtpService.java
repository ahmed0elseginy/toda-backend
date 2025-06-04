package com.toda.user.service.security;

public interface OtpService {
    String createOtpForUser(Long userId, String type);
    boolean validateOtp(Long userId, String inputOtp);
}
