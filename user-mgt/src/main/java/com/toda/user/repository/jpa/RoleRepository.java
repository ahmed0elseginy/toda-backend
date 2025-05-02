package com.toda.user.repository.jpa;

import com.toda.user.repository.entity.Role;
import com.toda.user.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
