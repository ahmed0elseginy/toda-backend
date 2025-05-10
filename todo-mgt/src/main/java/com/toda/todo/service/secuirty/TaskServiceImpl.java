package com.toda.todo.service.secuirty;

import com.toda.todo.error.exception.BusinessException;
import com.toda.todo.mapper.TaskMapper;
import com.toda.todo.model.dto.generated.CreateTodoDTO;
import com.toda.todo.model.dto.generated.TodoVTO;
import com.toda.todo.model.dto.generated.UpdateTodoDTO;
import com.toda.todo.repository.entity.Task;
import com.toda.todo.repository.entity.TaskDetails;
import com.toda.todo.repository.jpa.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.toda.todo.model.enums.TaskErrors.Task_NOT_FOUND;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public Long createTask(CreateTodoDTO createTodoDTO) {
        Task task = new Task();
        TaskDetails taskDetails = new TaskDetails();
        task.setTitle(createTodoDTO.getTitle());
        task.setCreatedById(createTodoDTO.getUserId());

        taskDetails.setDescription(createTodoDTO.getDescription());
        taskDetails.setPriority(taskMapper.map(createTodoDTO.getPriority()));
        taskDetails.setStatus(taskMapper.map(createTodoDTO.getStatus()));
        task.setDetails(taskDetails);

        taskRepository.save(task);

        return task.getId();
    }

    @Override
    public TodoVTO updateTask(Long taskId, UpdateTodoDTO updateTodoDTO) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new BusinessException(Task_NOT_FOUND));
        task = taskMapper.updateTask(updateTodoDTO, task);
        taskRepository.save(task);
        TodoVTO todoVTO = new TodoVTO();
        todoVTO.setId(task.getId());
        todoVTO.setTitle(task.getTitle());
        todoVTO.setDescription(task.getDescription());
        return todoVTO;
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new BusinessException(Task_NOT_FOUND));
        taskRepository.delete(task);
    }

    @Override
    public TodoVTO getTaskById(Long todoId) {
        Task task = taskRepository.findById(todoId)
                .orElseThrow(() -> new BusinessException(Task_NOT_FOUND));
        return taskMapper.toVTO(task);

    }

    @Override
    public List<TodoVTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TodoVTO> todoVTOs = new ArrayList<>();
        for (Task task : tasks) {
            TodoVTO todoVTO = new TodoVTO();
            todoVTO.setId(task.getId());
            todoVTO.setTitle(task.getTitle());
            todoVTO.setDescription(task.getDescription());
            todoVTOs.add(todoVTO);
        }
        return todoVTOs;
    }
}
