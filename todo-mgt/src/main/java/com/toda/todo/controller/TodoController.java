package com.toda.todo.controller;

import com.toda.todo.controller.generated.TodoApi;
import com.toda.todo.model.dto.generated.CreateTodoDTO;
import com.toda.todo.model.dto.generated.TodoResultSet;
import com.toda.todo.model.dto.generated.TodoVTO;
import com.toda.todo.model.dto.generated.UpdateTodoDTO;
import com.toda.todo.service.secuirty.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class TodoController implements TodoApi {

    private final TaskService taskService;

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
    public ResponseEntity<TodoResultSet> searchTodos(String title, String description, String priority, String status, Integer pageNum, Integer pageSize) {
        return TodoApi.super.searchTodos(title, description, priority, status, pageNum, pageSize);
    }

    @Override
    public ResponseEntity<TodoVTO> updateTodo(Long id, UpdateTodoDTO updateTodoDTO) {
        TodoVTO vto = taskService.updateTask(id, updateTodoDTO);
        return ResponseEntity.ok(vto);
    }
}
