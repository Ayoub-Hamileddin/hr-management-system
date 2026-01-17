package com.backend.backend.model;


import com.backend.backend.domain.EmployeeStatus;
import com.backend.backend.domain.Position;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
    @NotBlank(message = "phone cannot be empty")
    private String phone;

    @Enumerated(EnumType.STRING)
    private Position position;

    private double salary;

    private LocalDateTime hireDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    //    @OneToMany  LeaveRequest, Payroll, Attendance
}
