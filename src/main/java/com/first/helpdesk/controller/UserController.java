package com.first.helpdesk.controller;
import com.first.helpdesk.dto.UserRequestDTO;
import com.first.helpdesk.dto.UserResponseDTO;
import com.first.helpdesk.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.web.bind.annotation.*;
import com.first.helpdesk.entity.User;
import com.first.helpdesk.dto.LoginRequestDTO;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final  UserService userService;
    public UserController(UserService userService,AuthenticationManager authenticationManager){
        this.userService=userService;
        this.authenticationManager=authenticationManager;
    }
    @PostMapping //postman ke request me jo JSON  hai use java object me convert krke do
    //USE REQ when we are sending in JSON
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO){
        User user=new User();
        user.setName(userRequestDTO.getName());
        user.setRole(userRequestDTO.getRole());
        user.setEmail( userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        User savedUser= userService.createUser(user);
        return convertToResponseDTO(savedUser);
    }
    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
        List<User> users= userService.getAllUsers();
        List<UserResponseDTO> responseDTOS= new ArrayList<>();
        for(User user: users){
            responseDTOS.add(convertToResponseDTO(user));
        }
        return responseDTOS;
    }
    @GetMapping("/{id}")//jab url se value leni ho
    public  UserResponseDTO getUserById(@PathVariable int id){
        User user = userService.getUserById(id);
        return convertToResponseDTO(user);
    }
    @PutMapping("/{id}") //jab update krna ho
    public User updateUser(@PathVariable int id,@RequestBody User updatedUser){
        return userService.updateUser(id,updatedUser);
    }
@DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
}
@PostMapping("/login")
public boolean login(@RequestBody LoginRequestDTO loginRequestDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(),loginRequestDTO.getPassword()));
        return true;
}

UserResponseDTO convertToResponseDTO(User user){
UserResponseDTO responseDTO = new UserResponseDTO();
responseDTO.setEmail(user.getEmail());
responseDTO.setName(user.getName());
responseDTO.setId(user.getId());
responseDTO.setRole(user.getRole());
return responseDTO;
}
}
