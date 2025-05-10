package com.toda.todo.service.secuirty;

import com.toda.todo.model.dto.generated.CreateTodoDTO;
import com.toda.todo.model.dto.generated.TodoVTO;
import com.toda.todo.model.dto.generated.UpdateTodoDTO;

import java.util.List;

public interface TaskService {
    Long createTask(CreateTodoDTO createTodoDTO);

    TodoVTO updateTask(Long taskId, UpdateTodoDTO updateTodoDTO);

    void deleteTask(Long todoId);

    TodoVTO getTaskById(Long todoId);

    List<TodoVTO> getAllTasks();
}
