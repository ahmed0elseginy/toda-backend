package com.toda.user.service.security;

import com.toda.user.error.exception.BusinessException;
import com.toda.user.model.security.UserDTO;
import com.toda.user.model.security.UserPrincipal;
import com.toda.user.repository.entity.User;
import com.toda.user.repository.jpa.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static com.toda.user.model.enums.UserErrors.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class MyUserDetailsServie implements UserDetailsService {

    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(email);
        if (user != null)
            throw new BusinessException(USER_NOT_FOUND);

        return new UserPrincipal(UserDTO
                .builder()
                .id(user.getId())
                .username(user.getEmail())
                .password(user.getPassword())
                .build());
    }
}
