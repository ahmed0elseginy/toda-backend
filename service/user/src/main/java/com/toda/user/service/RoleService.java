package com.toda.user.service;

public interface RoleService {

    void assignRoleToUser(Long UserId, Integer roleId);

    void removeRoleFromUser(Long UserId, Integer roleId);
}
