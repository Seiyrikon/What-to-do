package com.what_to_do.backend.Todo;

import java.sql.Timestamp;

public record TodoDto (
    Long todo_id,
    String title,
    boolean isCompleted,
    Timestamp created_at,
    Timestamp updated_at
) 
{   

}
