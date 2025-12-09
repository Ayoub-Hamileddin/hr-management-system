package com.backend.backend.service;

import java.util.List;

import com.backend.backend.payload.DTO.UserDto.UserDto;
import com.backend.backend.payload.DTO.UserDto.UserUpdateDto;
import com.backend.backend.payload.response.DeleteResponse;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserUpdateDto updateDto,Long id);

    DeleteResponse deleteUser(Long id);

}
