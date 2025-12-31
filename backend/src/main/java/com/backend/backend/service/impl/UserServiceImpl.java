package com.backend.backend.service.impl;

import com.backend.backend.Exceptions.EmailAlreadyExistException;
import com.backend.backend.Exceptions.NotFoundException;
import com.backend.backend.Exceptions.UnauthorizedException;
import com.backend.backend.domain.Role;
import com.backend.backend.mapper.UserMapper;
import com.backend.backend.model.User;
import com.backend.backend.payload.DTO.UserDto.UserDto;
import com.backend.backend.payload.DTO.UserDto.UserUpdateDto;
import com.backend.backend.payload.DTO.authDto.RegisterRequest;
import com.backend.backend.payload.DTO.employeeDto.CreateEmployeeDto;
import com.backend.backend.payload.response.AuthResponse;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.repository.UserRepository;
import com.backend.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
        private final UserRepository userRepository;
        private final UserMapper userMapper;
        private final PasswordEncoder passwordEncoder;


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
    public AuthResponse createUser(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())){
            throw new UnauthorizedException("Email already exist");
        }

        var user=User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.ROLE_EMPLOYEE)
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(null)
                .build();

        User userSaved=userRepository.save(user);

        return  AuthResponse.builder()
                    .message("User created successfuly")
                    .access_token(null)
                    .refresh_token(null)
                    .user(userMapper.toDto(userSaved))

                .build();
    }

    @Override
    public UserDto updateUser(UserUpdateDto userUpdateDto,Long id) {

        User user=userRepository.findById(id).orElseThrow(
            ()->new NotFoundException("user", "User Not found")
        );
         userMapper.updateUserFromDto(userUpdateDto, user);

//         hashing the password
        if (userUpdateDto.getPassword() !=null) {
            user.setPassword(passwordEncoder.encode(userUpdateDto.getPassword()));
        }

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

    @Override
    public User createEmployeeUser(CreateEmployeeDto createEmployeeDto) {
        boolean existingEmail=userRepository.existsByEmail(createEmployeeDto.getEmail());

        if (existingEmail){
            throw new EmailAlreadyExistException("Employee email already exist");

        }

        return User.builder()

                .firstName(createEmployeeDto.getFirstName())
                .lastName(createEmployeeDto.getLastName())
                .email(createEmployeeDto.getEmail())
                .role(Role.ROLE_EMPLOYEE)
                .password(null)
                .isActive(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(null)

                .build();
    }


}
