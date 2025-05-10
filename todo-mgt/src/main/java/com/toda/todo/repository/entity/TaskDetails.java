package com.toda.todo.repository.entity;


import com.toda.todo.model.enums.Priority;
import com.toda.todo.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Task_details")
public class TaskDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "priority")
    private Priority priority;

    @Column(name = "status")
    private Status status;


}
