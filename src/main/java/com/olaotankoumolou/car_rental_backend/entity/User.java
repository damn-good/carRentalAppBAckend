package com.olaotankoumolou.car_rental_backend.entity;

import com.olaotankoumolou.car_rental_backend.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;

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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

}
