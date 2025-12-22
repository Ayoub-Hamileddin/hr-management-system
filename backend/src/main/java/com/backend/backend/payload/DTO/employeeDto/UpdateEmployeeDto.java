package com.backend.backend.payload.DTO.employeeDto;

import com.backend.backend.domain.EmployeeStatus;
import com.backend.backend.model.Department;
import com.backend.backend.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;



@Builder
@Data
public class UpdateEmployeeDto {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "firstName cannot be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "lastName cannot be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String lastName;

    @Email
    @Column(unique = true,nullable = false)
    private String email;

    @NotBlank(message = "phone cannot be empty")
    private String phone;

    private String position;

    private double salary;

    private LocalDateTime hireDate;


    private Department department;


    private User user;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
}
