package com.example.board.TaskEntity;

public record TaskDTO(Long id,String title,String description,String status) {
    public TaskDTO(TaskModel task){
        this(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
    }

}
