package com.example.board.kanban_tasks.TaskController;

import com.example.board.kanban_tasks.TaskEntity.TaskDTO;
import com.example.board.kanban_tasks.TaskEntity.TaskModel;
import com.example.board.kanban_tasks.TaskEntity.TaskRequestDTO;
import com.example.board.kanban_tasks.TaskRepository.TaskRepository;
import com.example.board.kanban_tasks.TaskService.TaskService;
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
        try {
            taskService.updateTask(id, "in_progress");
            return ResponseEntity.ok("Task moved to in_progress");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
    @PutMapping("/{id}/move-to-test")
    public ResponseEntity<String> moveTaskTest(@PathVariable("id") Long id){
        try {
            taskService.updateTask(id, "in_test");
            return ResponseEntity.ok("Task moved to in_test");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}/move-to-code-review")
    public ResponseEntity<String> moveTaskCodeReview(@PathVariable("id") Long id){
        try {
            taskService.updateTask(id, "code-review");
            return ResponseEntity.ok("Task moved to code-review");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}/move-to-done")
    public ResponseEntity<String> moveTaskDone(@PathVariable("id") Long id){
        try {
            taskService.updateTask(id, "done");
            return ResponseEntity.ok("Task moved to done");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id){
        try {
            taskService.deleteTaskService(id);
            return ResponseEntity.ok("Task deleted with sucess");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}/update-title")
    public ResponseEntity<String> updateTitle(@PathVariable("id") Long id,@RequestBody String newTitle){
        try {
            taskService.updateTitle(id,newTitle);
            return ResponseEntity.ok("title updated with sucess");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}/update-description")
    public ResponseEntity<String> updateDescription(@PathVariable("id") Long id, @RequestBody String newDescription){
        try{
            taskService.updateDescription(id,newDescription);
            return ResponseEntity.ok("description updated with sucess");

        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
