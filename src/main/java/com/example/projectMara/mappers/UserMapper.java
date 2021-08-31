package com.example.projectMara.mappers;

import com.example.projectMara.adapter.dto.UserLoginDto;
import com.example.projectMara.adapter.dto.UserRegistrationDto;
import com.example.projectMara.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "nickName", target = "nickName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(ignore = true, target = "password")
    UserRegistrationDto mapToUserRegistrationDto(User user);


    @Mapping(source = "nickName", target = "nickName")
    @Mapping(ignore = true, target = "password")
    UserLoginDto mapToUserLoginDto(User user);
}
