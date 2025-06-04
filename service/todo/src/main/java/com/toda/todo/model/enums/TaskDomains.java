package com.toda.todo.model.enums;

import com.toda.todo.error.interfaces.Domains;

public enum TaskDomains implements Domains<TaskDomains> {
    TASK(201, ""),
    USER(201, ""),
    LOGIN(102,""),
    ROLE(202, ""),
    SECURITY(101,""),
    JWT_TOKEN(103,"");
    ;

    TaskDomains(Integer id, String destination) {
        this.id = id;
        this.destination = destination;
    }

    private final Integer id;
    private final String destination;

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String destination() {
        return destination;
    }

}
