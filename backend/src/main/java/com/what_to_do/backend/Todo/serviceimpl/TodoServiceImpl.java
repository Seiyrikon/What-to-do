package com.what_to_do.backend.Todo.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.what_to_do.backend.Todo.TodoDao;
import com.what_to_do.backend.Todo.TodoDto;
import com.what_to_do.backend.Todo.TodoModel;
import com.what_to_do.backend.Todo.TodoService;
import com.what_to_do.backend.Todo.mapper.TodoDtoMapper;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoDao todoDao;

    @Autowired
    private TodoDtoMapper todoDtoMapper;

    Map<String, Object> response = new HashMap<String, Object>();

    @Override
    public ResponseEntity<Map<String, Object>> getAllTodo() {
        try {
            List<TodoDto> todos = todoDao.getAllTodo()
            .stream()
            .map(todoDtoMapper).collect(Collectors.toList());

            if(todos.size() != 0) {
                response.put("message", todos);
            } else {
                response.put("message", "No todo/s yet.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Internal Server Error");
            return ResponseEntity.status(500).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> addTodo(TodoModel body) {
        try {
            if(body != null) {
                todoDao.addTodo(body);
                response.put("message", "Todo added successfully.");
            } else {
                response.put("message", "Something went wrong");
                return ResponseEntity.status(401).body(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Internal Server Error");
            return ResponseEntity.status(500).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> markTodoComplete(Long todo_id) {
        try {
            if(todo_id != null) {
                todoDao.markTodoComplete(todo_id);
                response.put("message", "Todo is completed");
            } else {
                response.put("message", "Something went wrong");
                return ResponseEntity.status(401).body(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "Internal Server Error");
            return ResponseEntity.status(500).body(response);
        }

        return ResponseEntity.ok(response);
    }
    
}
