package com.toda.todo.service;

import com.toda.todo.error.exception.BusinessException;
import com.toda.todo.model.dto.generated.*;
import com.toda.todo.repository.entity.Todo;
import com.toda.todo.repository.entity.TodoDetails;
import com.toda.todo.repository.jpa.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.toda.todo.model.enums.TaskErrors.Task_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
//    private final TodoMapper todoMapper; // optional mapping if needed later

    @Override
    public Long createTask(CreateTodoDTO createTodoDTO) {
        Todo todo = new Todo();
        TodoDetails todoDetails = new TodoDetails();

        todo.setTitle(createTodoDTO.getTitle());
        todo.setCreatedById(createTodoDTO.getUserId());
        todoDetails.setDescription(createTodoDTO.getDescription());
        todoDetails.setPriority(createTodoDTO.getPriority());
        todoDetails.setStatus(createTodoDTO.getStatus());
        todoDetails.setCreatedAt(new Date());

        todo.setDetails(todoDetails);
        todoRepository.save(todo);
        return todo.getId();
    }

    @Override
    public TodoVTO updateTask(Long taskId, UpdateTodoDTO updateTodoDTO) {
        Todo todo = todoRepository.findById(taskId)
                .orElseThrow(() -> new BusinessException(Task_NOT_FOUND));
        todo.setTitle(updateTodoDTO.getTitle());
        TodoDetails todoDetails = todo.getDetails() != null ? todo.getDetails() : new TodoDetails();
        todoDetails.setDescription(updateTodoDTO.getDescription());
        todoDetails.setPriority(updateTodoDTO.getPriority());
        todoDetails.setStatus(updateTodoDTO.getStatus());
        todo.setDetails(todoDetails);
        todoRepository.save(todo);
        return buildTodoVTO(todo);
    }

    @Override
    public void deleteTask(Long taskId) {
        Todo todo = todoRepository.findById(taskId)
                .orElseThrow(() -> new BusinessException(Task_NOT_FOUND));
        todoRepository.delete(todo);
    }

    @Override
    public TodoVTO getTaskById(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new BusinessException(Task_NOT_FOUND));
        return buildTodoVTO(todo);
    }

    @Override
    public List<TodoVTO> getAllTasks() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(this::buildTodoVTO).collect(Collectors.toList());
    }

    @Override
    public TodoResultSet getBySearch(String title, String description, Priority priority, Status status,
                                     Integer pageNum, Integer pageSize) {
        List<Todo> todos = todoRepository.findAll();

        // Apply filters
        List<Todo> filtered = todos.stream()
                .filter(todo -> title == null || todo.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(todo -> description == null || (todo.getDetails() != null &&
                        todo.getDetails().getDescription() != null &&
                        todo.getDetails().getDescription().toLowerCase().contains(description.toLowerCase())))
                .filter(todo -> priority == null || (todo.getDetails() != null &&
                        priority.equals(todo.getDetails().getPriority())))
                .filter(todo -> status == null || (todo.getDetails() != null &&
                        status.equals(todo.getDetails().getStatus())))
                .toList();

        // Pagination logic
        int total = filtered.size();
        int page = pageNum != null ? pageNum : 0;
        int size = pageSize != null ? pageSize : total;

        int fromIndex = Math.min(page * size, total);
        int toIndex = Math.min(fromIndex + size, total);

        List<TodoVTO> pagedData = filtered.subList(fromIndex, toIndex).stream()
                .map(this::buildTodoVTO)
                .toList();

        // Build result set
        TodoResultSet resultSet = new TodoResultSet();
        resultSet.setData(pagedData);
        resultSet.setPageNum(page);
        resultSet.setPageSize(size);
        resultSet.setTotal((long) total);

        return resultSet;
    }

    private TodoVTO buildTodoVTO(Todo todo) {
        TodoVTO todoVTO = new TodoVTO();
        todoVTO.setId(todo.getId());
        todoVTO.setTitle(todo.getTitle());

        if (todo.getDetails() != null) {
            todoVTO.setDescription(todo.getDetails().getDescription());
            todoVTO.setPriority(todo.getDetails().getPriority());
            todoVTO.setStatus(todo.getDetails().getStatus());
        }

        return todoVTO;
    }
}
