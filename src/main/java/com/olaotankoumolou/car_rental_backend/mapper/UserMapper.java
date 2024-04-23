package com.olaotankoumolou.car_rental_backend.mapper;

import com.olaotankoumolou.car_rental_backend.dto.SignupRequestDto;
import com.olaotankoumolou.car_rental_backend.dto.UserDto;
import com.olaotankoumolou.car_rental_backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userDtoToUser(UserDto userDto);
    User signupRequestDtoToUser(SignupRequestDto signupRequestDto);
    UserDto userToUserDto(User user);
}
