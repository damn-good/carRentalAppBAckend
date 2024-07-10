package com.olaotankoumolou.car_rental_backend.configuration;

import com.olaotankoumolou.car_rental_backend.entity.User;
import com.olaotankoumolou.car_rental_backend.repository.UserRepository;
import com.olaotankoumolou.car_rental_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepository userRepository;
    private final UserService userService;

    @Bean
    UserDetailsService userDetailsService() {
        return (String username) -> {
            User currentUser = userRepository.findFirstByEmail(username);
            return userService.userDetailsFromUser(currentUser);
        };
    }
}
