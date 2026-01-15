package com.backend.backend.service.impl;

import com.backend.backend.Exceptions.NotFoundException;
import com.backend.backend.domain.Position;
import com.backend.backend.mapper.EmployeeMapper;
import com.backend.backend.model.Department;
import com.backend.backend.model.Employee;
import com.backend.backend.model.User;
import com.backend.backend.payload.DTO.employeeDto.CreateEmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.EmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.UpdateEmployeeDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.repository.DepartementRepository;
import com.backend.backend.repository.EmployeeRepository;
import com.backend.backend.service.EmployeeService;
import com.backend.backend.service.InvitationService;
import com.backend.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
        private final EmployeeRepository employeeRepository;
        private final EmployeeMapper employeeMapper;
        private final UserService userService;
        private final DepartementRepository departementRepository;
        private final InvitationService invitationService;


    //    get All employees
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();

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

        User user=userService.createEmployeeUser(createEmployeeDto);

        Department department=departementRepository.findById(createEmployeeDto.getDepartmentId()).orElseThrow(
                ()->new NotFoundException("departement","Departemnt Not found")
        );

        Employee employee=Employee.builder()

                .firstName(createEmployeeDto.getFirstName())
                .lastName(createEmployeeDto.getLastName())
                .email(createEmployeeDto.getEmail())
                .phone(createEmployeeDto.getPhone())
                .department(department)
                .position(Position.INTERN)
                .salary(5000)
                .user(user)
                .hireDate(LocalDateTime.now())

                .build();

        invitationService.sendInvitation(user);

        return employeeMapper.toDto(employee);
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
