package com.backend.backend.service;

import com.backend.backend.payload.DTO.employeeDto.CreateEmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.EmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.UpdateEmployeeDto;
import com.backend.backend.payload.response.DeleteResponse;

import java.util.List;

public interface EmployeeService {

        List<EmployeeDto> getAllEmployees ();

        EmployeeDto getEmployeeById(Long employeeId);

        EmployeeDto createEmployee(CreateEmployeeDto createEmployeeDto);

        EmployeeDto updateEmployee(Long employeeId, UpdateEmployeeDto updateEmployeeDto);

        DeleteResponse deleteEmployee(Long employeeId);

        List<EmployeeDto> SearchEmployeeByName(String name);
}
