package com.example.board.TaskEntity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Table(name = "tasks")
@Entity(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status = "backlog";

    public TaskModel(TaskRequestDTO data){
        this.title = data.title();
        this.description = data.description();
    }
}
