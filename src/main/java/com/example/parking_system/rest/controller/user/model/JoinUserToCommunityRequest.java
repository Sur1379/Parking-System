package com.example.parking_system.rest.controller.user.model;

import java.util.ArrayList;
import java.util.List;

public class JoinUserToCommunityRequest {
    private Long userId;
    private List<Long> communityIdList = new ArrayList<>();


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getCommunityIdList() {
        return communityIdList;
    }

    public void setCommunityIdList(List<Long> communityIdList) {
        this.communityIdList = communityIdList;
    }
}
