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
    public void moveTaskToInProgress(Long id){
        TaskModel taskModel = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("task not found"));
        System.out.println(repository.findById(id));
        taskModel.setStatus("in_progress");
        repository.save(taskModel);
    }

}
