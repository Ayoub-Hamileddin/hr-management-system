package com.backend.backend.controller;


import com.backend.backend.payload.DTO.employeeDto.CreateEmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.EmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.SetPasswordRequest;
import com.backend.backend.payload.DTO.employeeDto.UpdateEmployeeDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.service.EmployeeService;
import com.backend.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
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
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody CreateEmployeeDto createEmployeeDto)
    {
        return ResponseEntity.ok(employeeService.createEmployee(createEmployeeDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @RequestParam("id") Long employeeId,
            @RequestBody UpdateEmployeeDto updateEmployeeDto)

    {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId,updateEmployeeDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponse> deleteEmployee(@RequestParam("id") Long employeeId)
    {
        return  ResponseEntity.ok(employeeService.deleteEmployee(employeeId));
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
           return  ResponseEntity.ok(employeeService.getAllEmployees());
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam("id") Long employeeId)
    {
           return  ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
}
