package com.first.helpdesk.service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.first.helpdesk.repository.UserRepository;
import com.first.helpdesk.entity.User;
import com.first.helpdesk.dto.LoginRequestDTO;
import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    public User createUser(User user){
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
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
        User user= userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found with id "+ id));
        user.setEmail(updatedUser.getEmail());
        user.setName(updatedUser.getName());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        user.setRole(updatedUser.getRole());
        return userRepository.save(user);
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
    public boolean login(LoginRequestDTO loginRequestDTO){
        User user=userRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow();
        return passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword());
    }
}
