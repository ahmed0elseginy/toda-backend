package com.toda.todo.model.enums;

import com.toda.todo.error.interfaces.Domains;
import com.toda.todo.error.interfaces.Errors;

import static com.toda.todo.model.enums.TaskDomains.TASK;

public enum TaskErrors implements Errors<TaskErrors, TaskDomains> {
    Task_NOT_FOUND(TASK, "0001", "Task not found"),
    INVALID_REQUEST(TASK, "0002", "Invalid request to check user"),
    UNEXPECTED_ERROR(TASK, "0003", "Unexpected error occurred while checking user existence"),
    USER_NOT_FOUND(TASK, "0004", "User not found in the system");
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