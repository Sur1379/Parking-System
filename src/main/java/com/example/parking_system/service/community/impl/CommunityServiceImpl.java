package com.example.parking_system.service.community.impl;

import com.example.parking_system.persistence.community.CommunityRepository;
import com.example.parking_system.persistence.community.model.Community;
import com.example.parking_system.rest.controller.community.model.CommunityRequest;
import com.example.parking_system.service.community.CommunityService;
import com.example.parking_system.service.community.model.CommunityResponse;
import com.example.parking_system.service.parkingspace.ParkingSpaceService;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements CommunityService {
    private CommunityRepository communityRepository;
    private ParkingSpaceService parkingSpaceService;

    public CommunityServiceImpl(CommunityRepository communityRepository, ParkingSpaceService parkingSpaceService) {
        this.communityRepository = communityRepository;
        this.parkingSpaceService = parkingSpaceService;
    }

    @Override
    public CommunityResponse create(CommunityRequest communityRequest) {
        Community community = new Community();
        community.setName(communityRequest.getName());
        communityRepository.save(community);
        parkingSpaceService.create(community);
        return new CommunityResponse(community.getId(), communityRequest.getName());
    }

    @Override
    public Community getById(Long id) {
        return communityRepository.getCommunityById(id);
    }
}
