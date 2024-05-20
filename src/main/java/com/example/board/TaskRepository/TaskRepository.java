package com.example.board.TaskRepository;

import com.example.board.TaskEntity.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}