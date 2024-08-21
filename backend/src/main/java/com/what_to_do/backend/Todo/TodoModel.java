package com.what_to_do.backend.Todo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoModel {
    private Long todo_id;
    private String title;
    private boolean isCompleted;
    private Timestamp created_at;
    private Timestamp updated_at;
}
