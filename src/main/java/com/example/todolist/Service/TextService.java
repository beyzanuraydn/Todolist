package com.example.todolist.Service;

import com.example.todolist.Entity.Text;
import com.example.todolist.Entity.User;
import com.example.todolist.Repository.TextRepository;
import com.example.todolist.Request.TextCreateRequest;
import com.example.todolist.Request.TextUpdateRequest;
import com.example.todolist.Response.TextResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TextService {
    @Autowired
    private TextRepository textRepository;
    private UserService userService;
    public TextService (UserService userService){
        this.userService=userService;
    }

    public List<Text> getAllText(){
        return textRepository.findAll();
    }
    public Text createNewTask(Text text) {
        return textRepository.save(text);
    }

    public void saveText(Text text){
        textRepository.save(text);
    }

    public Text updateText(Text text){
        return textRepository.save(text);
    }
   public Text updateTextStatus(Long id){
        Text text = textRepository.findById(id).orElseThrow();
        text.setDone(!text.isDone());
        return textRepository.save(text);
   }
   public void deleteText(Long id) {
        textRepository.deleteById(id);
    }
    public List<TextResponse> getAllTexts(Optional<Long> userId){
        List<Text> list;
        if(userId.isPresent()){
            list=textRepository.findByUserId(userId.get());}
        else  list =textRepository.findAll();
        return list.stream().map(p->new TextResponse(p)).collect(Collectors.toList());
    }
    public Text getOneTextById(Long textId){
        return textRepository.findById(textId).orElse(null);
    }
 public Text createOneText(TextCreateRequest newTextRequest){
        User user = userService.getOneUser(newTextRequest.getUserId());
        if (user == null)
            return  null;
        Text toSave = new Text();
        toSave.setText(newTextRequest.getText());
        toSave.setDone(false);
        toSave.setUser(user);
        return textRepository.save(toSave);
 }
  public Text updateOneTextById(Long textId, TextUpdateRequest updateText){
        Optional<Text> text = textRepository.findById(textId);
        if(text.isPresent()){
            Text toUpdate = text.get();
            toUpdate.setText(updateText.getText());
            textRepository.save(toUpdate);
        }return null;
  }


}
