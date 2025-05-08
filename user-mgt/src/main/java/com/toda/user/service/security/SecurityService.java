package com.toda.user.service.security;

public interface SecurityService {
    String encryptPassword(String password);

    Boolean comparePasswords(String unHashedPassword, String hashedPassword);
}
