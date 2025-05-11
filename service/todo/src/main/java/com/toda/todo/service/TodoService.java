package com.toda.todo.service;

import com.toda.todo.model.dto.generated.*;

import java.util.List;

public interface TodoService {
    Long createTask(CreateTodoDTO createTodoDTO);

    TodoVTO updateTask(Long taskId, UpdateTodoDTO updateTodoDTO);

    void deleteTask(Long todoId);

    TodoVTO getTaskById(Long todoId);

    List<TodoVTO> getAllTasks();

    TodoResultSet getBySearch(String title, String description, Priority priority, Status status, Integer pageNum, Integer pageSize);
}
