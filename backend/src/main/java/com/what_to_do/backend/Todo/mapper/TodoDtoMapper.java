package com.what_to_do.backend.Todo.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.what_to_do.backend.Todo.TodoDto;
import com.what_to_do.backend.Todo.TodoModel;

@Service
public class TodoDtoMapper implements Function<TodoModel, TodoDto>{

    @Override
    public TodoDto apply(TodoModel todo) {
        return new TodoDto(
            todo.getTodo_id(), 
            todo.getTitle(), 
            todo.isCompleted(), 
            todo.getCreated_at(), 
            todo.getUpdated_at()
            );
    }
    
}
