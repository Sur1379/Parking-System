package com.example.parking_system.service.user.model;

public class UserResponse {
    private Long id;
    private String username;

    public UserResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
