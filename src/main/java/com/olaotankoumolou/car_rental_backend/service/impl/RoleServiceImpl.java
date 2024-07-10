package com.olaotankoumolou.car_rental_backend.service.impl;

import com.olaotankoumolou.car_rental_backend.entity.Role;
import com.olaotankoumolou.car_rental_backend.repository.RoleRepository;
import com.olaotankoumolou.car_rental_backend.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private static final String customer,admin;

    static {
        customer = "CUSTOMER";
        admin  = "ADMIN";
    }

    @Override
    @Transactional
    public Role getCustomerRole() {
        return roleRepository.findByName(customer)
                .orElseGet(() -> roleRepository.save(new Role(customer)));
    }
}
