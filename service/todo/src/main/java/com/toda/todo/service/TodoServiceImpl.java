package com.toda.todo.service;

import com.toda.todo.error.exception.BusinessException;
import com.toda.todo.mapper.TodoMapper;
import com.toda.todo.model.dto.generated.*;
import com.toda.todo.repository.entity.Todo;
import com.toda.todo.repository.entity.TodoDetails;
import com.toda.todo.repository.jpa.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.toda.todo.model.enums.TaskErrors.Task_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public Long createTodo(CreateTodoDTO createTodoDTO) {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Todo todo = new Todo();
        TodoDetails todoDetails = new TodoDetails();
        todo.setTitle(createTodoDTO.getTitle());
        todo.setCreatedById(userId);
        todoDetails.setDescription(createTodoDTO.getDescription());
        todoDetails.setPriority(createTodoDTO.getPriority());
        todoDetails.setStatus(createTodoDTO.getStatus());
        todoDetails.setCreatedAt(new Date());

        todo.setDetails(todoDetails);
        todoRepository.save(todo);
        return todo.getId();
    }

    @Override
    public TodoVTO updateTodo(Long todoId, UpdateTodoDTO updateTodoDTO) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new BusinessException(Task_NOT_FOUND));
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!todo.getCreatedById().equals(userId)) {
            throw new BusinessException(Task_NOT_FOUND);
        }

        todo.setTitle(updateTodoDTO.getTitle());
        TodoDetails todoDetails = Optional.ofNullable(todo.getDetails()).orElseGet(TodoDetails::new);
        todoDetails.setDescription(updateTodoDTO.getDescription());
        todoDetails.setPriority(updateTodoDTO.getPriority());
        todoDetails.setStatus(updateTodoDTO.getStatus());
        todo.setDetails(todoDetails);

        todoRepository.save(todo);
        return todoMapper.toTodoVTO(todo);
    }

    @Override
    public void deleteTodo(Long taskId) {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Todo todo = todoRepository.findById(taskId)
                .orElseThrow(() -> new BusinessException(Task_NOT_FOUND));
        if (todo.getCreatedById().equals(userId)) {
            todoRepository.delete(todo);
        } else {
            throw new BusinessException(Task_NOT_FOUND);
        }
    }

    @Override
    public TodoVTO getTodoById(Long todoId) {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new BusinessException(Task_NOT_FOUND));
        if (!todo.getCreatedById().equals(userId)) {
            throw new BusinessException(Task_NOT_FOUND);
        }
        return todoMapper.toTodoVTO(todo);
    }

    @Override
    public List<TodoVTO> getAllTodo() {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return todoRepository.findAll().stream()
                .map(todoMapper::toTodoVTO)
                .filter(todoVTO -> todoVTO.getCreatedById().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public TodoResultSet getBySearch(String title, String description, Priority priority, Status status,
                                     Integer pageNum, Integer pageSize) {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Todo> todos = todoRepository.findAll().stream()
                .filter(todo -> todo.getCreatedById().equals(userId))
                .collect(Collectors.toList());

        List<Todo> filtered = todos.stream()
                .filter(todo -> title == null || (todo.getTitle() != null && todo.getTitle().toLowerCase().contains(title.toLowerCase())))
                .filter(todo -> description == null || (todo.getDetails() != null &&
                        Optional.ofNullable(todo.getDetails().getDescription())
                                .map(desc -> desc != null && desc.toLowerCase().contains(description.toLowerCase()))
                                .orElse(false)))
                .filter(todo -> priority == null || (todo.getDetails() != null &&
                        priority.equals(todo.getDetails().getPriority())))
                .filter(todo -> status == null || (todo.getDetails() != null &&
                        status.equals(todo.getDetails().getStatus())))
                .collect(Collectors.toList());

        int total = filtered.size();
        int page = Optional.ofNullable(pageNum).orElse(0);
        int size = Optional.ofNullable(pageSize).orElse(total);

        int fromIndex = Math.min(page * size, total);
        int toIndex = Math.min(fromIndex + size, total);

        List<TodoVTO> pagedData = filtered.subList(fromIndex, toIndex).stream()
                .map(todoMapper::toTodoVTO)
                .collect(Collectors.toList());

        TodoResultSet resultSet = new TodoResultSet();
        resultSet.setData(pagedData);
        resultSet.setPageNum(page);
        resultSet.setPageSize(size);
        resultSet.setTotal((long) total);

        return resultSet;
    }
}