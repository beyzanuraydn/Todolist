package com.example.todolist.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="todo")
@Data
public class Text {
    @Id
    private Long id;
    private String text;
    private boolean isDone;
}