package com.toda.todo.controller;

import com.toda.todo.controller.generated.TodoController;
import com.toda.todo.model.dto.generated.*;
import com.toda.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TodoControllerImpl implements TodoController {
    private final TodoService todoService;

    @Override
    public ResponseEntity<Long> _createTodo(CreateTodoDTO createTodoDTO) {
        Long task = todoService.createTodo(createTodoDTO);
        return ResponseEntity.ok(task);
    }

    @Override
    public ResponseEntity<Void> _deleteTodo(Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TodoVTO> _getTodo(Long id) {
        TodoVTO todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    @Override
    public ResponseEntity<TodoResultSet> _searchTodos(String title, String description, Priority priority, Status status, Integer pageNum, Integer pageSize) {
        TodoResultSet results = todoService.getBySearch(title, description, priority, status, pageNum, pageSize);
        return ResponseEntity.ok(results);
    }

    @Override
    public ResponseEntity<TodoVTO> _updateTodo(Long id, UpdateTodoDTO updateTodoDTO) {
        TodoVTO vto = todoService.updateTodo(id, updateTodoDTO);
        return ResponseEntity.ok(vto);
    }
}
