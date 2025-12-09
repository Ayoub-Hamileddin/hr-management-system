package com.backend.backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.backend.backend.Exceptions.NotFoundException;
import com.backend.backend.mapper.UserMapper;
import com.backend.backend.model.User;
import com.backend.backend.payload.DTO.UserDto.UserDto;
import com.backend.backend.payload.DTO.UserDto.UserUpdateDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.repository.UserRepository;
import com.backend.backend.service.UserService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
        private final UserRepository userRepository;
        private final UserMapper userMapper;


    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=userRepository.findAll();
        return users.stream()
            .map(user ->userMapper.toDto(user))
        .toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(
            ()->new NotFoundException("user", "User Not found")
        );
        return userMapper.toDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=userMapper.toEntity(userDto);

        User userSaved=userRepository.save(user);

        return userMapper.toDto(userSaved);
    }

    @Override
    public UserDto updateUser(UserUpdateDto userDto,Long id) {

        User user=userRepository.findById(id).orElseThrow(
            ()->new NotFoundException("user", "User Not found")
        );

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setIsActive(userDto.getIsActive());
        user.setUpdatedAt(LocalDateTime.now());

        User userSaved=userRepository.save(user);
        return userMapper.toDto(userSaved);

    }

    @Override
    public DeleteResponse deleteUser(Long id) {
         User user=userRepository.findById(id).orElseThrow(
            ()->new NotFoundException("user", "User Not found")
        );

        return DeleteResponse.builder()
            .message("Deleted User successfuly")
            .userId(user.getId())
            .status(HttpStatus.NO_CONTENT.value())
        .build();
    }

}
