package com.backend.backend.payload.DTO.employeeDto;

import com.backend.backend.domain.EmployeeStatus;
import lombok.Data;




@Data
public class UpdateEmployeeDto {
    //user
    private String firstName;

    private String lastName;

    private String email;

    // employee
    private String phone;

    private String position;

    private Double salary;

    private EmployeeStatus status;
}
