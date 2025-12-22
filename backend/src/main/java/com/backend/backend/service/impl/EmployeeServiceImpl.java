package com.backend.backend.service.impl;

import com.backend.backend.Exceptions.NotFoundException;
import com.backend.backend.mapper.EmployeeMapper;
import com.backend.backend.model.Employee;
import com.backend.backend.payload.DTO.employeeDto.CreateEmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.EmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.UpdateEmployeeDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.repository.EmployeeRepository;
import com.backend.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
        private final EmployeeRepository employeeRepository;
        private final EmployeeMapper employeeMapper;


    //    get All employees
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();

            if (employees.isEmpty() || employees==null){
                throw new NotFoundException("Employee","Employee Not Found");
            }

        return employees.stream()
                .map(employee-> employeeMapper.toDto(employee))
                .toList();
    }

    // find the employee by his Id .
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee= employeeRepository.findById(employeeId).orElseThrow(
                ()-> new NotFoundException("Employee","employee not found with this id :" + employeeId)
        );
        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDto createEmployee(CreateEmployeeDto createEmployeeDto) {


        return null;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, UpdateEmployeeDto updateEmployeeDto) {
        return null;
    }

    @Override
    public DeleteResponse deleteEmployee(Long employeeId) {
        return null;
    }

    @Override
    public EmployeeDto SearchEmployeeByName(String name) {
        return null;
    }
}
