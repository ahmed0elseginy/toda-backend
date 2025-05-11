package com.toda.user.service.security;

import com.toda.user.model.security.UserDTO;
import com.toda.user.repository.entity.User;
import com.toda.user.repository.entity.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JWTService {

    private static byte[] secretKey = null;
    private final Long EXPIRATION_TIME = 24L * 3600 * 1000;

    public String generateToken(User user, List<UserRole> roles) {
        KeyGenerator keyGenerator;
        try {
            keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        SecretKey key = keyGenerator.generateKey();
        secretKey = Base64.getEncoder().encode(key.getEncoded());

        Map<String, Object> claims = new HashMap<>();
        claims.put("USER_ID", user.getId());

        List<String> roleNames = roles.stream()
                .map(userRole -> userRole.getRole().getTitleEn())
                .collect(Collectors.toList());
        claims.put("ROLES", roleNames);

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(user.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000))) // مدة الصلاحية 1 ساعة
                .and()
                .signWith(getKey())
                .compact();
    }


    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secretKey);
    }

    public String extractUserName(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    public boolean validateToken(String token, UserDetails userDetails) {
        String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date tokenExpiredDate = extractAllClaims(token).getExpiration();
        return tokenExpiredDate.before(new Date());
    }


}
