package com.toda.user.repository.jpa;

import com.toda.user.repository.entity.OtpToken;
import com.toda.user.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.Optional;

public interface OtpTokenRepository extends JpaRepository<OtpToken, Long> {
    Optional<OtpToken> findTopByUserAndUsedFalseAndExpiresAtAfterOrderByCreatedAtDesc(User user, LocalDateTime now);
}

