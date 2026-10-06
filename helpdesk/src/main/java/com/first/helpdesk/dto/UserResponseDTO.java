package com.first.helpdesk.dto;

import com.first.helpdesk.entity.User;

public class UserResponseDTO {
    private int id;
    private String name;
    private String email;
    private User.Role role;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public User.Role getRole() {
        return role;
    }
    public void setRole(User.Role role) {
        this.role = role;
    }
    public UserResponseDTO(){}


}
