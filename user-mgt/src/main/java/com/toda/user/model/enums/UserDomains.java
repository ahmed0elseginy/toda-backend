package com.toda.user.model.enums;

import com.toda.user.common.interfaces.Domains;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserDomains implements Domains<UserDomains> {
    USER(201, ""), ROLE(202, ""),
    SECURITY(101,""),
    LOGIN(102,""),
    JWT_TOKEN(103,"");
    ;

    private final Integer id;
    private final String destination;

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String destination() {
        return destination;
    }

}
