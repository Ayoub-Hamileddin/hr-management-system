package com.backend.backend.controller;


import com.backend.backend.payload.DTO.employeeDto.CreateEmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.EmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.SetPasswordRequest;
import com.backend.backend.payload.DTO.employeeDto.UpdateEmployeeDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.service.EmployeeService;
import com.backend.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final UserService userService;
    private final EmployeeService employeeService;

    @PostMapping("/set-password")
    public ResponseEntity<String> activateEmployeeAccount(@RequestBody SetPasswordRequest setPasswordRequest)
    {
        userService.setPassword(setPasswordRequest);
       return ResponseEntity.ok("Password set successfully") ;
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody CreateEmployeeDto createEmployeeDto)
    {
        return ResponseEntity.ok(employeeService.createEmployee(createEmployeeDto));
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id ")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable("id") Long employeeId,
            @Valid
            @RequestBody UpdateEmployeeDto updateEmployeeDto)

    {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId,updateEmployeeDto));
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeleteResponse> deleteEmployee(@PathVariable("id") Long employeeId)
    {
        return  ResponseEntity.ok(employeeService.deleteEmployee(employeeId));
    }


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
           return  ResponseEntity.ok(employeeService.getAllEmployees());
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId)
    {
           return  ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
}
