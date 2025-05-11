package com.toda.todo.controller;

import com.toda.todo.controller.generated.TodoApi;
import com.toda.todo.model.dto.generated.*;
import com.toda.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TodoController implements TodoApi {
    public TodoController(TodoService taskService) {
        this.taskService = taskService;
    }

    private final TodoService taskService;

    @Override
    public ResponseEntity<Long> createTodo(CreateTodoDTO createTodoDTO) {
        Long task = taskService.createTask(createTodoDTO);
        return ResponseEntity.ok(task);
    }

    @Override
    public ResponseEntity<Void> deleteTodo(Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TodoVTO> getTodo(Long id) {
        TodoVTO todo = taskService.getTaskById(id);
        return ResponseEntity.ok(todo);
    }

    @Override
    public ResponseEntity<TodoVTO> updateTodo(Long id, UpdateTodoDTO updateTodoDTO) {
        TodoVTO vto = taskService.updateTask(id, updateTodoDTO);
        return ResponseEntity.ok(vto);
    }

    @Override
    public ResponseEntity<TodoResultSet> searchTodos(String title, String description, Priority priority, Status status, Integer pageNum, Integer pageSize) {
        TodoResultSet results = taskService.getBySearch(title, description, priority, status, pageNum, pageSize);
        return ResponseEntity.ok(results);
    }
}
