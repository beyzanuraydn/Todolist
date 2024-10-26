package com.example.todolist.Response;

import com.example.todolist.Entity.Text;
import lombok.Data;

@Data
public class TextResponse {
    Long id;
    Long userId;
    String userName;
    String text;
    boolean done;

    public TextResponse(Text entity){
        this.id=entity.getId();
        this.userId=entity.getUser().getId();
        this.userName=entity.getUser().getUserName();
        this.text= entity.getText();
        this.done=entity.isDone();

    }
}
