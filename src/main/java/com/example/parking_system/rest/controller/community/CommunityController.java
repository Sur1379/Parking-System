package com.example.parking_system.rest.controller.community;

import com.example.parking_system.rest.controller.community.model.CommunityRequest;
import com.example.parking_system.service.community.CommunityService;
import com.example.parking_system.service.community.model.CommunityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityController {
    private CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping("/createCommunity")
    public ResponseEntity<CommunityResponse>
    createCommunity(@RequestBody CommunityRequest communityRequest){
        return new ResponseEntity<>(communityService.create(communityRequest),
                HttpStatus.CREATED);
    }
}
