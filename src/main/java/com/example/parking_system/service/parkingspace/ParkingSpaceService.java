package com.example.parking_system.service.parkingspace;

import com.example.parking_system.persistence.community.model.Community;
import com.example.parking_system.persistence.parkingspace.model.ParkingSpace;
import com.example.parking_system.rest.controller.user.model.JoinUserToParkingSpaceRequest;

public interface ParkingSpaceService {
    void create(Community community);

    ParkingSpace getFreeSpace(Community community, JoinUserToParkingSpaceRequest joinUserToParkingSpaceRequest);
}
