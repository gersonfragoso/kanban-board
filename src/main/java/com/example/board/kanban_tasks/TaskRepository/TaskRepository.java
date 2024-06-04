package com.example.board.kanban_tasks.TaskRepository;

import com.example.board.kanban_tasks.TaskEntity.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}