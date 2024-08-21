package com.what_to_do.backend.Todo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoDao {
    List<TodoModel> getAllTodo();
    void addTodo(TodoModel body);
    void markTodoComplete(Long todo_id);
}
