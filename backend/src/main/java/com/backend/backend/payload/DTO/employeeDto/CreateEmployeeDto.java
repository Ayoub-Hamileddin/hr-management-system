package com.backend.backend.payload.DTO.employeeDto;

import com.backend.backend.domain.Position;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class CreateEmployeeDto {

    @NotBlank(message = "firstName cannot be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "lastName cannot be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String lastName;

    @Email
    @Column(unique = true,nullable = false)
    private String email;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
    @NotBlank(message = "phone cannot be empty")
    private String phone;

    @NotBlank(message = "position cannot be empty")
    private Position position;

    private Double salary;

    @NotBlank(message = "department id cannot be empty")
    private Long  departmentId;



}
