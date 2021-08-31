package com.example.parking_system.persistence.parkingspace.model;

import com.example.parking_system.persistence.community.model.Community;
import com.example.parking_system.persistence.userparkingspace.model.UserParkingSpace;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Community community;

    @OneToMany(mappedBy = "parkingSpace")
    List<UserParkingSpace> userParkingSpaceList = new ArrayList();

    public ParkingSpace(Community community) {
        this.community = community;
    }

    public ParkingSpace() {
    }

    public Long getId() {

        return id;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public List<UserParkingSpace> getUserParkingSpaceList() {
        return userParkingSpaceList;
    }

    public void setUserParkingSpaceList(List<UserParkingSpace> userParkingSpaceList) {
        this.userParkingSpaceList = userParkingSpaceList;
    }
}
