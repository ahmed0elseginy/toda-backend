package com.toda.todo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Status {
    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED");

    Status(String value) {
        this.value = value;
    }

    private final String value;
}
