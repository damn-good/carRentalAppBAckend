package com.olaotankoumolou.car_rental_backend.dto;

import com.olaotankoumolou.car_rental_backend.customValidator.UniqueEmail;
import com.olaotankoumolou.car_rental_backend.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequestDto {
    @NotBlank(message = "INVALID_NAME")
    String name;
    @Email(message = "INVALID_EMAIL")
    @UniqueEmail()
    String email;
    @Size(min = 6, max = 20, message = "INVALID_PASSWORD")
    String password;
}
