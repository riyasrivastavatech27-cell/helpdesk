package com.first.helpdesk.controller;
import com.first.helpdesk.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.first.helpdesk.entity.User;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {

    private final  UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping //postman ke request me jo JSON  hai use java object me convert krke do
    //USE REQ when we are sending in JSON
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")//jab url se value leni ho
    public  User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @PutMapping //jab update krna ho
    public User updateUser(@PathVariable int id,@RequestBody User updatedUser){
        return userService.updateUser(id,updatedUser);
    }
@DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
}
}
