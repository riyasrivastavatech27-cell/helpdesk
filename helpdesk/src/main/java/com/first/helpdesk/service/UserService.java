package com.first.helpdesk.service;

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.stereotype.Service;
import com.first.helpdesk.repository.UserRepository;
import com.first.helpdesk.entity.User;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User createUser(User user){
        return userRepository.save(user); //jpa receive user save it in database and return the saved user
    }//why return the saved object coz it generates the ID
    public User getUserById(int id){
        return userRepository.findById(id).orElseThrow();
        //optional<User> if not return throw
    }
    public List<User> getAllUsers (){
        return userRepository.findAll();
    }
    public User updateUser(int id,User updatedUser){
        User user= userRepository.findById(id).orElseThrow();
        user.setEmail(updatedUser.getEmail());
        user.setName(updatedUser.getName());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());
        return userRepository.save(user);
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
