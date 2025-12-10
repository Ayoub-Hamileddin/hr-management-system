package com.backend.backend.service;

import com.backend.backend.payload.DTO.UserDto.UserDto;
import com.backend.backend.payload.DTO.UserDto.UserUpdateDto;
import com.backend.backend.payload.DTO.authDto.RegisterRequest;
import com.backend.backend.payload.response.AuthResponse;
import com.backend.backend.payload.response.DeleteResponse;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    AuthResponse createUser(RegisterRequest registerRequest);

    UserDto updateUser(UserUpdateDto updateDto,Long id);

    DeleteResponse deleteUser(Long id);

}
