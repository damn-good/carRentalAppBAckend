package com.olaotankoumolou.car_rental_backend.service;

import com.olaotankoumolou.car_rental_backend.dto.SignupRequestDto;
import com.olaotankoumolou.car_rental_backend.dto.UserDto;
import com.olaotankoumolou.car_rental_backend.entity.User;
import com.olaotankoumolou.car_rental_backend.enums.UserRole;
import com.olaotankoumolou.car_rental_backend.mapper.UserMapper;
import com.olaotankoumolou.car_rental_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean findExistingEmail(String email) {
        Optional<User> existing = userRepository.findFirstByEmail(email);
        return existing.isPresent();
    }

    @Override
    public UserDto createCustomer(SignupRequestDto signupRequestDto) {
        User customer = UserMapper.INSTANCE.signupRequestDtoToUser(signupRequestDto);
        customer.setRole(UserRole.CUSTOMER);
        userRepository.save(customer);
        return UserMapper.INSTANCE.userToUserDto(customer);
    }
}
