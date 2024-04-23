package com.olaotankoumolou.car_rental_backend.controller;

import com.olaotankoumolou.car_rental_backend.dto.SignupRequestDto;
import com.olaotankoumolou.car_rental_backend.dto.UserDto;
import com.olaotankoumolou.car_rental_backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody SignupRequestDto signupRequest){
        UserDto createdUser = userService.createCustomer(signupRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
