package com.toda.user.service.security;

import com.toda.user.repository.entity.OtpToken;
import com.toda.user.repository.entity.User;
import com.toda.user.repository.jpa.OtpTokenRepository;
import com.toda.user.repository.jpa.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl {
    private final OtpTokenRepository otpTokenRepository;

    private final UserRepository userRepository;

    private static final int OTP_LENGTH = 6;
    private static final int EXPIRY_MINUTES = 5;

    private String generateOtpCode() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    @Transactional
    public String createOtpForUser(Long userId, String type) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = userOpt.get();

        String otpCode = generateOtpCode();
        LocalDateTime now = LocalDateTime.now();

        OtpToken otp = new OtpToken();
        otp.setUser(user);
        otp.setOtpCode(otpCode);
        otp.setCreatedAt(now);
        otp.setExpiresAt(now.plusMinutes(EXPIRY_MINUTES));
        otp.setUsed(false);
        otp.setType(type);

        otpTokenRepository.save(otp);
        return otpCode;
    }

    public boolean validateOtp(Long userId, String inputOtp) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) return false;

        LocalDateTime now = LocalDateTime.now();
        Optional<OtpToken> otpOpt = otpTokenRepository.findTopByUserAndUsedFalseAndExpiresAtAfterOrderByCreatedAtDesc(userOpt.get(), now);

        if (otpOpt.isEmpty()) return false;

        OtpToken otp = otpOpt.get();
        if (otp.getOtpCode().equals(inputOtp)) {
            otp.setUsed(true);
            otpTokenRepository.save(otp);
            return true;
        }
        return false;
    }
}
