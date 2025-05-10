package com.toda.todo.model.enums;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Server
public enum Priority {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH");

    Priority(String value) {
        this.value = value;
    }

    private final String value;
}
