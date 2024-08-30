package com.example.todolist.Controller;

import com.example.todolist.Entity.Text;
import com.example.todolist.Service.TextService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TextController {
    TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

    @GetMapping("/getAllText")
    public List<Text> getAllText(){
        return textService.getAllText();
    }
}
