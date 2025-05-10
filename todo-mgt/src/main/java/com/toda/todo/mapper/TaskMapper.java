package com.toda.todo.mapper;

import com.toda.todo.model.dto.generated.CreateTodoDTO;
import com.toda.todo.model.dto.generated.TodoVTO;
import com.toda.todo.model.dto.generated.UpdateTodoDTO;
import com.toda.todo.model.enums.Priority;
import com.toda.todo.model.enums.Status;
import com.toda.todo.repository.entity.Task;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface TaskMapper {

    Priority map(CreateTodoDTO.PriorityEnum priorityEnum);

    Status map(CreateTodoDTO.StatusEnum statusEnum);

    Task toTask(CreateTodoDTO dto);

    Task updateTask(UpdateTodoDTO dto, @MappingTarget Task task);

    TodoVTO toVTO(Task task);
}
