package com.example.todolist.Repository;

import com.example.todolist.Entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text,Long> {
}
