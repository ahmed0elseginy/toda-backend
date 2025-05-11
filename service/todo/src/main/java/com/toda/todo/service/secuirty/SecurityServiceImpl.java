//package com.toda.todo.service.secuirty;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SecurityServiceImpl implements SecurityService {
//    private final PasswordEncoder passwordEncoder;
//
//    public SecurityServiceImpl(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public String encryptPassword(String password) {
//        return passwordEncoder.encode(password);
//    }
//
//    @Override
//    public Boolean comparePasswords(String unHashedPassword, String hashedPassword) {
//        return passwordEncoder.matches(unHashedPassword, hashedPassword);
//    }
//}
