package com.toda.user.service;

import com.toda.user.error.exception.BusinessException;
import com.toda.user.repository.entity.Role;
import com.toda.user.repository.entity.User;
import com.toda.user.repository.entity.UserRole;
import com.toda.user.repository.jpa.RoleRepository;
import com.toda.user.repository.jpa.UserRepository;
import com.toda.user.repository.jpa.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.toda.user.model.enums.UserErrors.ROLE_NOT_FOUND;
import static com.toda.user.model.enums.UserErrors.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public void assignRoleToUser(Long UserId, Integer roleId) {
        User user = userRepository.findById(UserId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new BusinessException(ROLE_NOT_FOUND));
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRole(role);
        userRoleRepository.save(userRole);
    }

    @Override
    public void removeRoleFromUser(Long UserId, Integer roleId) {
        User user = userRepository.findById(UserId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new BusinessException(ROLE_NOT_FOUND));
        UserRole userRole = userRoleRepository.findByUserIdAndRoleId(user.getId(), role.getId());
        if (userRole!= null) {
            userRoleRepository.delete(userRole);
        }
    }
}
