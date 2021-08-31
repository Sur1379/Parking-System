package com.example.parking_system.persistence.user;

import com.example.parking_system.persistence.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(Long id);
}
