package com.example.parking_system.service.community;

import com.example.parking_system.persistence.community.model.Community;
import com.example.parking_system.rest.controller.community.model.CommunityRequest;
import com.example.parking_system.service.community.model.CommunityResponse;

public interface CommunityService {
    CommunityResponse create(CommunityRequest communityRequest);
    Community getById(Long id);
}
