//package com.toda.todo.mapper;
//
//import com.toda.todo.repository.entity.Todo;
//import org.mapstruct.*;
//
//@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
//@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
//public abstract class TodoMapper {
//
//    public abstract Todo toTask(CreateTodoDTO dto);
//
//    public abstract Todo updateTask(UpdateTodoDTO dto, @MappingTarget Todo todo);
//
//    public abstract TodoVTO toVTO(Todo todo);
//}
