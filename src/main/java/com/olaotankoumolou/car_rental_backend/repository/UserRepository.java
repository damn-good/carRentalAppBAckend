package com.olaotankoumolou.car_rental_backend.repository;

import com.olaotankoumolou.car_rental_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);
}
