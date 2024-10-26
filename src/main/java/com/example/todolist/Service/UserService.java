package com.example.todolist.Service;

import com.example.todolist.Entity.User;
import com.example.todolist.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
 UserRepository userRepository;
  public UserService(UserRepository userRepository){
     this.userRepository= userRepository;
 }
  public List<User> getAllUsers(){
     return userRepository.findAll();
 }
  public User saveOneUser(User newUser){
     return userRepository.save(newUser);
  }
 public User getOneUser(Long userId) {return userRepository.findById(userId).orElse(null);}
  public  User updateOneUser(Long userId,User newUser){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            User foundUser =user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            foundUser.setEmail(newUser.getEmail());
            userRepository.save(foundUser);
            return foundUser;
        } else return null;
  }
  public void deleteById(Long userId){
      userRepository.deleteById(userId);
  }

  public User getOneUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

}

