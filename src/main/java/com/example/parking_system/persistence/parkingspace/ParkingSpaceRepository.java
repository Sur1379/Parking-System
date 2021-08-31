package com.example.parking_system.persistence.parkingspace;

import com.example.parking_system.persistence.parkingspace.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {

}
