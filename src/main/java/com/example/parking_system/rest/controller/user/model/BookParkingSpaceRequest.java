package com.example.parking_system.rest.controller.user.model;

import com.example.parking_system.persistence.parkingspace.model.ParkingSpace;
import com.example.parking_system.persistence.user.model.User;

import java.util.Date;

public class BookParkingSpaceRequest {
    private User user;
    private ParkingSpace parkingSpace;
    private Date start;
    private Date end;

    public BookParkingSpaceRequest(User user, ParkingSpace parkingSpace, Date start, Date end) {
        this.user = user;
        this.parkingSpace = parkingSpace;
        this.start = start;
        this.end = end;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
