package com.toda.user.controller;

import com.toda.user.controller.generated.RoleController;
import com.toda.user.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
public class RoleControllerImpl implements RoleController {
    private final RoleService roleService;

    //    @Secured({ADMIN_ROLE})
    @Override
    public ResponseEntity<Void> _assignRoleToUser(Long userId, Integer roleId) {
        roleService.assignRoleToUser(userId, roleId);
        return ResponseEntity.status(CREATED).build();
    }

    //    @Secured({ADMIN_ROLE})
    @Override
    public ResponseEntity<Void> _removeRoleFromUser(Long userId, Integer roleId) {
        roleService.removeRoleFromUser(userId, roleId);
        return ResponseEntity.noContent().build();
    }
}
