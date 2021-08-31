package com.example.parking_system.service.userparkingspace.impl;

import com.example.parking_system.persistence.userparkingspace.UserParkingSpaceRepository;
import com.example.parking_system.persistence.userparkingspace.model.UserParkingSpace;
import com.example.parking_system.rest.controller.user.model.BookParkingSpaceRequest;
import com.example.parking_system.service.userparkingspace.UserParkingSpaceService;
import org.springframework.stereotype.Service;

@Service
public class UserParkingSpaceServiceImpl implements UserParkingSpaceService {
    UserParkingSpaceRepository userParkingSpaceRepository;

    public UserParkingSpaceServiceImpl(UserParkingSpaceRepository userParkingSpaceRepository) {
        this.userParkingSpaceRepository = userParkingSpaceRepository;
    }

    @Override
    public void book(BookParkingSpaceRequest request) {
        UserParkingSpace userParkingSpace = new UserParkingSpace(request.getUser()
        , request.getParkingSpace()
        , request.getStart()
        ,request.getEnd());
        userParkingSpaceRepository.save(userParkingSpace);
    }
}
