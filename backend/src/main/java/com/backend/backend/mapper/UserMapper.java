package com.backend.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.backend.backend.model.User;
import com.backend.backend.payload.DTO.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
