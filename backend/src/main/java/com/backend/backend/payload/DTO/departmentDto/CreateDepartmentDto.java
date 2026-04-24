package com.backend.backend.payload.DTO.departmentDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDepartmentDto {
    @NotBlank(message = "Department name cannot be blank")
    private String name;
    private String description;
}
