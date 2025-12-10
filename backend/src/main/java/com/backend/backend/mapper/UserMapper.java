package com.backend.backend.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.backend.backend.model.User;
import com.backend.backend.payload.DTO.UserDto.UserDto;
import com.backend.backend.payload.DTO.UserDto.UserUpdateDto;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserDto toDto(User user);
    User toEntity(UserDto userDto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) 
    void updateUserFromDto(UserUpdateDto dto,@MappingTarget User entity);
}
