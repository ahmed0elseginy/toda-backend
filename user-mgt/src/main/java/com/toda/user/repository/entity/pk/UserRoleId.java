package com.toda.user.repository.entity.pk;

import com.toda.user.repository.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserRoleId implements Serializable {
    private Role role; /// foreign key to role table

    private Long userId; /// foreign key to user table
}
