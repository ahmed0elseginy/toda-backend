package com.toda.todo.mapper;

import com.toda.todo.model.dto.generated.TodoVTO;
import com.toda.todo.repository.entity.Todo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public abstract class TodoMapper {
    @Mapping(target = "description", source = "details.description")
    @Mapping(target = "priority", source = "details.priority")
    @Mapping(target = "status", source = "details.status")
    @Mapping(target = "createdAt", source = "details.createdAt")
    public abstract TodoVTO toTodoVTO(Todo todo);
}
