package com.toda.user.model.enums;

import com.toda.user.common.interfaces.Domains;
import com.toda.user.error.interfaces.Errors;
import lombok.AllArgsConstructor;

import static com.toda.user.model.enums.UserDomains.ROLE;
import static com.toda.user.model.enums.UserDomains.USER;

@AllArgsConstructor
public enum UserErrors implements Errors<UserErrors, UserDomains> {
    USER_NOT_FOUND(USER, "0001", "User not found"),
    MOBILE_NUMBER_ALREADY_EXIST(USER, "0002", "Mobile Number already exists"),
    EMAIL_ALREADY_EXIST(USER, "0003", "This email already exists"),
    ROLE_NOT_FOUND(ROLE, "0001", "Role not found"),

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
