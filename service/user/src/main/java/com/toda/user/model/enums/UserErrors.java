package com.toda.user.model.enums;

import com.toda.user.common.interfaces.Domains;
import com.toda.user.error.interfaces.Errors;
import lombok.AllArgsConstructor;

import static com.toda.user.model.enums.UserDomains.*;

@AllArgsConstructor
public enum UserErrors implements Errors<UserErrors, UserDomains> {
    USER_NOT_FOUND(USER, "0001", "User not found"),
    MOBILE_NUMBER_ALREADY_EXIST(USER, "0002", "Mobile Number already exists"),
    EMAIL_ALREADY_EXIST(USER, "0003", "This email already exists"),
    USER_ALREADY_ACTIVATED(USER, "0004", "User already activated"),
    ROLE_NOT_FOUND(ROLE, "0001", "Role not found"),
    TOKEN_USER_NOT_FOUND(LOGIN, "0004", "User of the token is not Found in the System"),
    INVALID_CREDENTIALS(SECURITY, "0001", "Invalid credentials, Wrong Email or Password"),
    UNAUTHORIZED(SECURITY, "0002", "Unauthorized"), //UNAUTHORIZED
    ;
    private final Domains<UserDomains> domain;
    private final String code;
    private final String defaultMessage;

    @Override
    public Domains<UserDomains> domain() {
        return domain;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String defaultMessage() {
        return defaultMessage;
    }
}
