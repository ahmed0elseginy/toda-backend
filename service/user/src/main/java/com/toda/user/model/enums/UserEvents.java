package com.toda.user.model.enums;

import com.toda.user.common.interfaces.Domains;
import com.toda.user.common.interfaces.Events;
import lombok.AllArgsConstructor;

import static com.toda.user.model.enums.UserDomains.USER;


@AllArgsConstructor
public enum UserEvents implements Events {
    CREATE_USER(1, USER),;

    private final Integer id;
    private final Domains domain;

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public Domains domain() {
        return domain;
    }


}
