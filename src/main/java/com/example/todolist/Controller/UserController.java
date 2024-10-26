package com.example.todolist.Controller;

import com.example.todolist.Entity.User;
import com.example.todolist.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
     this.userService= userService;}
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/createUser")
    public User createUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);
    }
    @GetMapping("/GetOneUser/{userId}")
    public  User GetOneUser(@PathVariable Long userId){
        return userService.getOneUser(userId);
    }
    @PutMapping("/update/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
        return userService.updateOneUser(userId,newUser);
    }
    @DeleteMapping("/delete/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteById(userId);
    }
}
