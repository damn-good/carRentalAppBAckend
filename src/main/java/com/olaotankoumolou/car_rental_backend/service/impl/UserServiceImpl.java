package com.olaotankoumolou.car_rental_backend.service.impl;

import com.olaotankoumolou.car_rental_backend.dto.SignupRequestDto;
import com.olaotankoumolou.car_rental_backend.dto.UserDto;
import com.olaotankoumolou.car_rental_backend.entity.Role;
import com.olaotankoumolou.car_rental_backend.entity.User;
import com.olaotankoumolou.car_rental_backend.enums.UserRole;
import com.olaotankoumolou.car_rental_backend.mapper.UserMapper;
import com.olaotankoumolou.car_rental_backend.repository.RoleRepository;
import com.olaotankoumolou.car_rental_backend.repository.UserRepository;
import com.olaotankoumolou.car_rental_backend.service.RoleService;
import com.olaotankoumolou.car_rental_backend.service.UserService;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public boolean findExistingEmail(String email) {
        User existing = userRepository.findFirstByEmail(email);
        return existing != null;
    }

    @Override
    public UserDto createCustomer(SignupRequestDto signupRequestDto) {
        signupRequestDto.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        User customer = UserMapper.INSTANCE.signupRequestDtoToUser(signupRequestDto);
        customer.setRoles(Collections.singletonList(roleService.getCustomerRole()));
        userRepository.save(customer);
        return UserMapper.INSTANCE.userToUserDto(customer);
    }

    @Override
    public UserDetails userDetailsFromUser(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles().stream().map(Role::getName).collect(Collectors.joining(", ")))
                .build();
    }
}
