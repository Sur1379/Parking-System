package com.example.parking_system.service.user;

import com.example.parking_system.rest.controller.user.model.JoinUserToCommunityRequest;
import com.example.parking_system.rest.controller.user.model.JoinUserToParkingSpaceRequest;
import com.example.parking_system.rest.controller.user.model.UserRequest;
import com.example.parking_system.service.user.model.UserResponse;

public interface UserService {

    UserResponse create(UserRequest userRequest);

    boolean join(JoinUserToCommunityRequest joinUserToCommunityRequest);

    boolean book(JoinUserToParkingSpaceRequest joinUserToParkingSpaceRequest);
}
