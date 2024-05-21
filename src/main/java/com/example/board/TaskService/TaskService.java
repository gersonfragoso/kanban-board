package com.example.board.TaskService;

import com.example.board.TaskEntity.TaskModel;
import com.example.board.TaskRepository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class TaskService {
    @Autowired
    protected TaskRepository repository;
    @Transactional
    public void updateTask(Long id, String newStatus){
        TaskModel taskModel = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("task not found"));

        String currentStatus = taskModel.getStatus();
        if (!isValidTransional(currentStatus,newStatus)){
            throw new IllegalArgumentException("Invalid transition from "+currentStatus+" to "+ newStatus);
        }
        taskModel.setStatus(newStatus);
        repository.save(taskModel);
    }

    public boolean isValidTransional(String currentStatus, String newStatus){
        switch(currentStatus){
            case "backlog":
                return newStatus.equals("in_progress");
            case "in_progress":
                return newStatus.equals("in_test");
            case "in_test":
                return newStatus.equals("code_review");
            case "code_review":
                return newStatus.equals("done");
            case "done":
                return false;
            default:
                return false;
        }

    }

    public void deleteTaskService(Long id){
        TaskModel task = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("task not exist"));
        repository.delete(task);
    }
}
