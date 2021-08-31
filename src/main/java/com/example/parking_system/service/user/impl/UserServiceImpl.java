package com.example.parking_system.service.user.impl;

import com.example.parking_system.persistence.community.model.Community;
import com.example.parking_system.persistence.parkingspace.model.ParkingSpace;
import com.example.parking_system.persistence.user.UserRepository;
import com.example.parking_system.persistence.user.model.User;
import com.example.parking_system.rest.controller.user.model.BookParkingSpaceRequest;
import com.example.parking_system.rest.controller.user.model.JoinUserToCommunityRequest;
import com.example.parking_system.rest.controller.user.model.JoinUserToParkingSpaceRequest;
import com.example.parking_system.rest.controller.user.model.UserRequest;
import com.example.parking_system.service.community.CommunityService;
import com.example.parking_system.service.parkingspace.ParkingSpaceService;
import com.example.parking_system.service.user.UserService;
import com.example.parking_system.service.user.model.UserResponse;
import com.example.parking_system.service.userparkingspace.UserParkingSpaceService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private CommunityService communityService;
    private ParkingSpaceService parkingSpaceService;
    private UserParkingSpaceService userParkingSpaceService;

    public UserServiceImpl(UserRepository userRepository, CommunityService communityService, ParkingSpaceService parkingSpaceService, UserParkingSpaceService userParkingSpaceService) {
        this.userRepository = userRepository;
        this.communityService = communityService;
        this.parkingSpaceService = parkingSpaceService;
        this.userParkingSpaceService = userParkingSpaceService;
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = userRepository.save(new User(userRequest.getUsername()));
        return new UserResponse(user.getId(), user.getUsername());
    }

    @Override
    public boolean join(JoinUserToCommunityRequest joinUserToCommunityRequest) {
        AtomicInteger count = new AtomicInteger();
        User user = userRepository.getUserById(joinUserToCommunityRequest.getUserId());
        if (Objects.nonNull(user)) {
            joinUserToCommunityRequest.getCommunityIdList().forEach(each -> {
                        Community community = communityService.getById(each);
                        if (Objects.nonNull(community)) {
                            count.getAndIncrement();
                            user.getCommunityList().add(community);
                        }
                    }
            );
            if (count.get() == 0) {
                return false;
            }
        } else return false;
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean book(JoinUserToParkingSpaceRequest joinUserToParkingSpaceRequest) {
        User user = userRepository.getUserById(joinUserToParkingSpaceRequest.getUserId());
        Community community = communityService
                .getById(joinUserToParkingSpaceRequest.getCommunityId());
        if (Objects.nonNull(user) && Objects.nonNull(community)) {
            ParkingSpace freeSpace = parkingSpaceService
                    .getFreeSpace(community, joinUserToParkingSpaceRequest);
            if (Objects.nonNull(freeSpace)) {
                BookParkingSpaceRequest bookParkingSpaceRequest =
                        new BookParkingSpaceRequest(user, freeSpace,
                                joinUserToParkingSpaceRequest.getStart(),
                                joinUserToParkingSpaceRequest.getEnd());
                userParkingSpaceService.book(bookParkingSpaceRequest);
            }
            else return false;

        } else return false;
        return true;
    }
}
