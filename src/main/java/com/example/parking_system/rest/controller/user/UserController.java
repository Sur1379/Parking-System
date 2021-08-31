package com.example.parking_system.rest.controller.user;

import com.example.parking_system.rest.controller.user.model.JoinUserToCommunityRequest;
import com.example.parking_system.rest.controller.user.model.JoinUserToParkingSpaceRequest;
import com.example.parking_system.rest.controller.user.model.UserRequest;
import com.example.parking_system.service.user.UserService;
import com.example.parking_system.service.user.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserResponse>
    createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.create(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PostMapping("/joinToCommunity")
    public ResponseEntity joinUserToCommunity
            (@RequestBody JoinUserToCommunityRequest joinUserToCommunityRequest) {
        boolean join = userService.join(joinUserToCommunityRequest);
        if (join) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/joinToParkingSpace")
    public ResponseEntity joinToParkingSpace(@RequestBody JoinUserToParkingSpaceRequest joinUserToParkingSpaceRequest){
        boolean book = userService.book(joinUserToParkingSpaceRequest);
        if (book) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
