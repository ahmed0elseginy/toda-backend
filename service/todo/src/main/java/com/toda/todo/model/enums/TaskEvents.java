package com.toda.todo.model.enums;//package com.toda.todo.model.enums;

import com.toda.todo.error.interfaces.Domains;
import com.toda.todo.error.interfaces.Events;
import lombok.AllArgsConstructor;

import static com.toda.todo.model.enums.TaskDomains.TASK;

@AllArgsConstructor
public enum TaskEvents implements Events {
    CREATE_TASK(1, TASK),;

    private final Integer id;
    private final Domains domain;

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public Domains domain() {
        return domain;
    }


}
