package com.example.parking_system.utils;

import com.example.parking_system.persistence.user.UserRepository;
import com.example.parking_system.persistence.user.model.User;
import com.example.parking_system.persistence.userparkingspace.UserParkingSpaceRepository;
import com.example.parking_system.persistence.userparkingspace.model.UserParkingSpace;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

public class CleanFinishedSpaces {
    UserRepository userRepository;
    UserParkingSpaceRepository userParkingSpaceRepository;

    public CleanFinishedSpaces(UserRepository userRepository, UserParkingSpaceRepository userParkingSpaceRepository) {
        this.userRepository = userRepository;
        this.userParkingSpaceRepository = userParkingSpaceRepository;
    }

    @Scheduled(fixedDelay = 1000 * 60 * 15)
    public void cleanParkingSpaces() {
        List<UserParkingSpace> all = userParkingSpaceRepository.findAll();
        for (int i = 0; i < all.size(); i++) {
            if ((all.get(i).getEnd() == null &&
                    new Date().getTime() - all.get(i).getStart().getTime() >= 300000)
                    || new Date().getTime() >= all.get(i).getEnd().getTime()) {
                UserParkingSpace byId = userParkingSpaceRepository.getById(all.get(i).getId());
                User userById = userRepository.getUserById(all.get(i).getUser().getId());
                userById.getUserParkingSpace().remove(byId);
                userParkingSpaceRepository.deleteById(all.get(i).getId());
            }

        }
    }
}
