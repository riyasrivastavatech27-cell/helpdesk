package com.first.helpdesk.dto;

public class LogicRequestDTO {
    private String email;
    private String password;
    public LogicRequestDTO(){}

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
}
