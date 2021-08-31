package com.example.parking_system.persistence.userparkingspace;

import com.example.parking_system.persistence.userparkingspace.model.UserParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserParkingSpaceRepository extends JpaRepository<UserParkingSpace, Long> {

}
