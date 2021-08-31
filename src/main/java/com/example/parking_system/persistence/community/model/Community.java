package com.example.parking_system.persistence.community.model;


import com.example.parking_system.persistence.parkingspace.model.ParkingSpace;
import com.example.parking_system.persistence.user.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "communityList")
    private List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy = "community")
    private List<ParkingSpace> parkingSpaceList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<ParkingSpace> getParkingSpaceList() {
        return parkingSpaceList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setParkingSpaceList(List<ParkingSpace> parkingSpaceList) {
        this.parkingSpaceList = parkingSpaceList;
    }
}
