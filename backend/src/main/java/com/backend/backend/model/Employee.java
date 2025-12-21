package com.backend.backend.model;


import com.backend.backend.domain.EmployeeStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
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

    @ManyToOne
    private Department department;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private EmployeeStatus status;

    //    @OneToMany  LeaveRequest, Payroll, Attendance
}
