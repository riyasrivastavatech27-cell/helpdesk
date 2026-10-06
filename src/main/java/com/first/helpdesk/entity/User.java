package com.first.helpdesk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //database entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//db automatically generate the ID
    private int id;
    private String name;
    private String email;
    private String password;

    public enum Role {
        CUSTOMER,
        AGENT,
        ADMIN
    }

    private Role role;//role variable only contain a Role value

    //user.setRole(Role.CUSTOMER);
    public User() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}