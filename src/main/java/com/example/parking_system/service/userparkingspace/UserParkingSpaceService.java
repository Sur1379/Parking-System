package com.example.parking_system.service.userparkingspace;

import com.example.parking_system.rest.controller.user.model.BookParkingSpaceRequest;

public interface UserParkingSpaceService {
    void book(BookParkingSpaceRequest bookParkingSpaceRequest);
}
