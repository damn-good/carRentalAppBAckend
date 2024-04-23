package com.olaotankoumolou.car_rental_backend.dto;

import com.olaotankoumolou.car_rental_backend.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    Long id;
    @NotBlank(message = "INVALID_NAME")
    String name;
    @Email(message = "INVALID_EMAIL")
    String email;
    UserRole role;
}
