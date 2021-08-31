package com.example.parking_system.persistence.community;

import com.example.parking_system.persistence.community.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {

    Community getCommunityById(Long id);

}
