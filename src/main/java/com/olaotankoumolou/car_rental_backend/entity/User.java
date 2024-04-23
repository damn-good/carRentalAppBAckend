package com.olaotankoumolou.car_rental_backend.entity;

import com.olaotankoumolou.car_rental_backend.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String password;
    UserRole role;

}
