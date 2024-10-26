package com.example.todolist.Request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class TextCreateRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    Boolean done;
    Long userId;
}
