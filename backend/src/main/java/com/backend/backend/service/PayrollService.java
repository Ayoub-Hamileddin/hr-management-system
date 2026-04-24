package com.backend.backend.service;

import com.backend.backend.payload.DTO.payrollDto.CreatePayrollDto;
import com.backend.backend.payload.DTO.payrollDto.PayrollDto;
import com.backend.backend.payload.DTO.payrollDto.UpdatePayrollDto;
import com.backend.backend.payload.response.DeleteResponse;

import java.util.List;

public interface PayrollService {
    PayrollDto createPayroll(CreatePayrollDto createPayrollDto);
    PayrollDto updatePayrollStatus(Long id, UpdatePayrollDto updatePayrollDto);
    DeleteResponse deletePayroll(Long id);
    PayrollDto getPayrollById(Long id);
    List<PayrollDto> getAllPayrolls();
    List<PayrollDto> getPayrollsByEmployeeId(Long employeeId);
}
