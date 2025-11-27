package com.backend.backend.mapper;

import org.mapstruct.Mapper;

import com.backend.backend.model.User;
import com.backend.backend.payload.DTO.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
