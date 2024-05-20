package com.example.board.TaskController;

import com.example.board.TaskEntity.TaskDTO;
import com.example.board.TaskEntity.TaskModel;
import com.example.board.TaskEntity.TaskRequestDTO;
import com.example.board.TaskRepository.TaskRepository;
import com.example.board.TaskService.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    protected TaskService taskService;
    @Autowired
    protected TaskRepository repository;

    @GetMapping
    public List<TaskDTO> getTask(){
        List<TaskDTO> task = repository.findAll().stream().map(TaskDTO::new).toList();

        return task;
    }

    @PostMapping
    public void createTask(@RequestBody TaskRequestDTO data){
        TaskModel taskData = new TaskModel(data);
        repository.save(taskData);
    }

    @PutMapping("/{id}/move-to-in-progress")
    public ResponseEntity<String> moveTaskProgress(@PathVariable("id") Long id){
        taskService.moveTaskToInProgress(id);
        return ResponseEntity.ok("ok");
    }
}
