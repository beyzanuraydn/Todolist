package com.example.todolist.Service;

import com.example.todolist.Entity.Text;
import com.example.todolist.Repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TextService {
    @Autowired
    private TextRepository textRepository;
    public List<Text> getAllText(){
        return textRepository.findAll();
    }
}
