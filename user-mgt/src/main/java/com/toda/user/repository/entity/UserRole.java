package com.toda.user.repository.entity;

import com.toda.user.repository.entity.pk.UserRoleId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(UserRoleId.class)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_role")
public class UserRole {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @CreatedDate
    @Column(name = "created_on")
    private Date createdOn;

}


