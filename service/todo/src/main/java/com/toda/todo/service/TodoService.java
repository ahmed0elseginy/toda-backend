package com.toda.todo.service;

import com.toda.todo.model.dto.generated.*;

import java.util.List;

public interface TodoService {
    Long createTodo(CreateTodoDTO createTodoDTO);

    TodoVTO updateTodo(Long todoId, UpdateTodoDTO updateTodoDTO);

    void deleteTodo(Long todoId);

    TodoVTO getTodoById(Long todoId);

    List<TodoVTO> getAllTodo();

    TodoResultSet getBySearch(String title, String description, Priority priority, Status status, Integer pageNum, Integer pageSize);
}
