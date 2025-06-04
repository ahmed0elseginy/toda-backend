package com.toda.user.service.security;


import com.toda.user.repository.entity.User;

import java.util.Optional;

public interface SecurityService {

    Boolean comparePasswords(String unHashedPassword, String hashedPassword);

}
