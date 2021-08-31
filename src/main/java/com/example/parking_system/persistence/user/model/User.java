package com.example.parking_system.persistence.user.model;

import com.example.parking_system.persistence.community.model.Community;
import com.example.parking_system.persistence.userparkingspace.model.UserParkingSpace;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @ManyToMany
    @JoinTable(
            name = "user_community",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "community_id") }
    )
    private List<Community> communityList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserParkingSpace> userParkingSpace = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Community> getCommunityList() {
        return communityList;
    }

    public List<UserParkingSpace> getUserParkingSpace() {
        return userParkingSpace;
    }

    public void setCommunityList(List<Community> communityList) {
        this.communityList = communityList;
    }

    public void setUserParkingSpace(List<UserParkingSpace> userParkingSpace) {
        this.userParkingSpace = userParkingSpace;
    }
}
