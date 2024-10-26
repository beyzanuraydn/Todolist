package com.example.todolist.Controller;

import com.example.todolist.Entity.Text;
import com.example.todolist.Entity.User;
import com.example.todolist.Request.TextCreateRequest;
import com.example.todolist.Request.TextUpdateRequest;
import com.example.todolist.Response.TextResponse;
import com.example.todolist.Service.TextService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/")
    public ResponseEntity<Text> createTask(@RequestBody Text text) {
        return ResponseEntity.ok(textService.createNewTask(text));
    }

    @PostMapping("/saveText")
    public void createText(@RequestBody String text){
        Text data = new Text();
        data.setText(text);
        data.setDone(false);
        textService.saveText(data);
    }

    // text,isDone güncellenir
    @PutMapping("/update/{id}")
    public Text updateText(@PathVariable Long id,@RequestBody Text text){
        text.setId(id);
        return textService.updateText(text);
    }
    // isDone durum değişimi
    @PutMapping("/done/{id}")
    public ResponseEntity<Text> updataTextStatus(@PathVariable Long id){
        Text updatedText =  textService.updateTextStatus(id);
        return ResponseEntity.ok(updatedText);
    }
    //seçilen id veri tabanından silinir
    @DeleteMapping("/delete/{id}")
    public void deleteText(@PathVariable Long id) {
        textService.deleteText(id);
    }

 @GetMapping("/getAllTexts")
 public List<TextResponse> getAllTexts(@RequestParam Optional<Long> userId){
        return textService.getAllTexts(userId);
 }
  @GetMapping("/{textId}")
    public Text getOneText(@PathVariable Long textId){
        return textService.getOneTextById(textId);
  }
  @PostMapping("/createOneText")
 public Text createOneText(@RequestBody TextCreateRequest newTextRequest){
        return textService.createOneText(newTextRequest);
 }

 @PutMapping("/{textId}")
 public  Text updateOneText(@PathVariable Long textId, @RequestBody TextUpdateRequest updateText){
        return textService.updateOneTextById(textId,updateText);
 }

}


