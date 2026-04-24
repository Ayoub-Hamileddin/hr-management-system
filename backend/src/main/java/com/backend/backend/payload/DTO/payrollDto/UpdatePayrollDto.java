package com.backend.backend.payload.DTO.payrollDto;

import com.backend.backend.domain.PayrollStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePayrollDto {
    @NotNull(message = "Status cannot be null")
    private PayrollStatus status;
}
