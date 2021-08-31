package com.example.parking_system.service.parkingspace.impl;

import com.example.parking_system.persistence.community.model.Community;
import com.example.parking_system.persistence.parkingspace.ParkingSpaceRepository;
import com.example.parking_system.persistence.parkingspace.model.ParkingSpace;
import com.example.parking_system.persistence.userparkingspace.model.UserParkingSpace;
import com.example.parking_system.rest.controller.user.model.JoinUserToParkingSpaceRequest;
import com.example.parking_system.service.parkingspace.ParkingSpaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    private ParkingSpaceRepository parkingSpaceRepository;

    public ParkingSpaceServiceImpl(ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    @Override
    public void create(Community community) {
        for (int i = 0; i < 10; i++) {
            parkingSpaceRepository.save(new ParkingSpace(community));
        }
    }

    @Override
    public ParkingSpace getFreeSpace(Community community, JoinUserToParkingSpaceRequest joinUserToParkingSpaceRequest) {
        List<ParkingSpace> parkingSpaceList = community.getParkingSpaceList();
        for (int i = 0; i < parkingSpaceList.size(); i++) {
            List<UserParkingSpace> userParkingSpaceList = parkingSpaceList.get(i).getUserParkingSpaceList();
            if (userParkingSpaceList.size() == 0) {
                return parkingSpaceList.get(i);
            }
            boolean isAvailable = true;
            for (int j = 0; j < userParkingSpaceList.size() && isAvailable; j++) {
                if (joinUserToParkingSpaceRequest.getEnd().getTime()
                        > userParkingSpaceList.get(j).getStart().getTime() &&
                        joinUserToParkingSpaceRequest.getEnd().getTime() <
                                userParkingSpaceList.get(j).getEnd().getTime()) {
                    isAvailable = false;
                } else if (joinUserToParkingSpaceRequest.getStart().getTime()
                        > userParkingSpaceList.get(j).getStart().getTime() &&
                        joinUserToParkingSpaceRequest.getStart().getTime() <
                                userParkingSpaceList.get(j).getEnd().getTime()) {
                    isAvailable = false;
                } else if (joinUserToParkingSpaceRequest.getEnd().getTime()
                        > userParkingSpaceList.get(j).getEnd().getTime() &&
                        joinUserToParkingSpaceRequest.getStart().getTime() <
                                userParkingSpaceList.get(j).getStart().getTime()) {
                    isAvailable = false;
                }
            }
            if(isAvailable) return parkingSpaceList.get(i);
        }
        return null;
    }


}
