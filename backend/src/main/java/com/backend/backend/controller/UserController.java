package com.backend.backend.controller;

import com.backend.backend.payload.DTO.UserDto.UserDto;
import com.backend.backend.payload.DTO.UserDto.UserUpdateDto;
import com.backend.backend.payload.DTO.authDto.RegisterRequest;
import com.backend.backend.payload.response.AuthResponse;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id ")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AuthResponse> createUser(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(userService.createUser(registerRequest));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN' or #id==authentication.principal.id)")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id ,
                                              @RequestBody UserUpdateDto updateDto) {
        return ResponseEntity.ok(userService.updateUser(updateDto,id));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeleteResponse> updateUser(@PathVariable("id") Long id ) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }



}
