package com.toda.todo.model.enums;

import com.toda.todo.common.interfaces.Domains;
import com.toda.todo.error.interfaces.Errors;
import lombok.AllArgsConstructor;

import static com.toda.todo.model.enums.TaskDomains.TASK;

public enum TaskErrors implements Errors<TaskErrors, TaskDomains> {
    Task_NOT_FOUND(TASK, "0001", "Task not found");

    private final Domains<TaskDomains> domain;
    private final String code;
    private final String defaultMessage;

    TaskErrors(Domains<TaskDomains> domain, String code, String defaultMessage) {
        this.domain = domain;
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public Domains<TaskDomains> domain() {
        return domain;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String defaultMessage() {
        return defaultMessage;
    }
}