//package com.toda.todo.service.secuirty;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class JWTService {
//
//    private final String SECRET_KEY = "your-secret-key"; // Use a secure key in production
//    private final long EXPIRATION_TIME = 86400000L; // 1 day expiration time
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public String extractUserName(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public boolean validateToken(String token, UserDetails userDetails) {
//        return (userDetails.getUsername().equals(extractUserName(token)) && !isTokenExpired(token));
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractClaim(token, Claims::getExpiration).before(new Date());
//    }
//
//    private <T> T extractClaim(String token, ClaimsResolver<T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.resolve(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    @FunctionalInterface
//    public interface ClaimsResolver<T> {
//        T resolve(Claims claims);
//    }
//}
