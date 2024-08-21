package com.what_to_do.backend.Todo;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface TodoService {
    public ResponseEntity<Map<String, Object>> getAllTodo();
    public ResponseEntity<Map<String, Object>> addTodo(TodoModel body);
    public ResponseEntity<Map<String, Object>> markTodoComplete(Long todo_id);
}
