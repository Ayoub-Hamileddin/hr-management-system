package com.backend.backend.payload.DTO.employeeDto;

import com.backend.backend.domain.EmployeeStatus;
import com.backend.backend.model.Department;
import com.backend.backend.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;



@Builder
@Data
public class EmployeeDto {

    private Long id;


    private String firstName;


    private String lastName;


    private String email;


    private String phone;

    private String position;

    private Double salary;


    private LocalDateTime hireDate;


    private Department department;


    private User user;


    private EmployeeStatus status;
}
