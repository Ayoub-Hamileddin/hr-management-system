package com.backend.backend.payload.DTO.payrollDto;

import com.backend.backend.domain.PayrollStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayrollDto {
    private Long id;
    private Long employeeId;
    private String employeeName;
    private Integer month;
    private Integer year;
    private Double baseSalary;
    private Double deductions;
    private Double bonuses;
    private Double netSalary;
    private LocalDate paymentDate;
    private PayrollStatus status;
}
