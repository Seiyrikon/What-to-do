package com.what_to_do.backend.Todo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class TodoRestController {
    
    @Autowired
    private TodoService todoService;

    @GetMapping("todos")
    public ResponseEntity<Map<String, Object>> getAllTodo() {
        return todoService.getAllTodo();
    }

    @PostMapping("todo/add")
    public ResponseEntity<Map<String, Object>> addTodo(@RequestBody TodoModel body) {
        return todoService.addTodo(body);
    }

    @PutMapping("todo/{todo_id}")
    public ResponseEntity<Map<String, Object>> markTodoComplete(@PathVariable Long todo_id) {
        return todoService.markTodoComplete(todo_id);
    }
}
