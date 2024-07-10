package com.olaotankoumolou.car_rental_backend.service;

import com.olaotankoumolou.car_rental_backend.dto.SignupRequestDto;
import com.olaotankoumolou.car_rental_backend.dto.UserDto;
import com.olaotankoumolou.car_rental_backend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserService {
    boolean findExistingEmail(String email);

    UserDto createCustomer(SignupRequestDto signupRequestDto);

    UserDetails userDetailsFromUser(User user);
}
