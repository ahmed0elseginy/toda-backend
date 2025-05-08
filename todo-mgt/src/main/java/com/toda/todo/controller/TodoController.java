package com.toda.todo.controller;

import com.toda.todo.controller.generated.TodoApi;
import com.toda.todo.model.dto.generated.CreateTodoDTO;
import com.toda.todo.model.dto.generated.TodoResultSet;
import com.toda.todo.model.dto.generated.TodoVTO;
import com.toda.todo.model.dto.generated.UpdateTodoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

public class TodoController implements TodoApi {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return TodoApi.super.getRequest();
    }

    @Override
    public ResponseEntity<TodoVTO> createTodo(CreateTodoDTO createTodoDTO) {
        return TodoApi.super.createTodo(createTodoDTO);
    }

    @Override
    public ResponseEntity<Void> deleteTodo(Long id) {
        return TodoApi.super.deleteTodo(id);
    }

    @Override
    public ResponseEntity<TodoVTO> getTodo(Long id) {
        return TodoApi.super.getTodo(id);
    }

    @Override
    public ResponseEntity<TodoResultSet> searchTodos(String title, String description, String priority, String status, Integer pageNum, Integer pageSize) {
        return TodoApi.super.searchTodos(title, description, priority, status, pageNum, pageSize);
    }

    @Override
    public ResponseEntity<TodoVTO> updateTodo(Long id, UpdateTodoDTO updateTodoDTO) {
        return TodoApi.super.updateTodo(id, updateTodoDTO);
    }
}
