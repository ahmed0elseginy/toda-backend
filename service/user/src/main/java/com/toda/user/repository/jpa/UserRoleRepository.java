package com.toda.user.repository.jpa;

import com.toda.user.repository.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByUserId(Long id);
    UserRole findByUserIdAndRoleId(Long userId, Integer roleId);
}
