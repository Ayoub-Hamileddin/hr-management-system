package com.backend.backend.service.impl;

import com.backend.backend.Exceptions.ResourceNotFoundException;
import com.backend.backend.domain.PayrollStatus;
import com.backend.backend.mapper.PayrollMapper;
import com.backend.backend.model.Employee;
import com.backend.backend.model.Payroll;
import com.backend.backend.payload.DTO.payrollDto.CreatePayrollDto;
import com.backend.backend.payload.DTO.payrollDto.PayrollDto;
import com.backend.backend.payload.DTO.payrollDto.UpdatePayrollDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.repository.EmployeeRepository;
import com.backend.backend.repository.PayrollRepository;
import com.backend.backend.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {

    private final PayrollRepository payrollRepository;
    private final EmployeeRepository employeeRepository;
    private final PayrollMapper payrollMapper;

    @Override
    public PayrollDto createPayroll(CreatePayrollDto createPayrollDto) {
        Employee employee = employeeRepository.findById(createPayrollDto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Payroll payroll = payrollMapper.toEntity(createPayrollDto);
        payroll.setEmployee(employee);
        payroll.setStatus(PayrollStatus.PENDING);
        
        Double deductions = createPayrollDto.getDeductions() != null ? createPayrollDto.getDeductions() : 0.0;
        Double bonuses = createPayrollDto.getBonuses() != null ? createPayrollDto.getBonuses() : 0.0;
        payroll.setNetSalary(createPayrollDto.getBaseSalary() + bonuses - deductions);

        Payroll savedPayroll = payrollRepository.save(payroll);
        return payrollMapper.toDto(savedPayroll);
    }

    @Override
    public PayrollDto updatePayrollStatus(Long id, UpdatePayrollDto updatePayrollDto) {
        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll not found"));

        payrollMapper.updateEntityFromDto(updatePayrollDto, payroll);
        
        if (updatePayrollDto.getStatus() == PayrollStatus.PAID) {
            payroll.setPaymentDate(LocalDate.now());
        }

        Payroll updatedPayroll = payrollRepository.save(payroll);
        return payrollMapper.toDto(updatedPayroll);
    }

    @Override
    public DeleteResponse deletePayroll(Long id) {
        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll not found"));

        payrollRepository.delete(payroll);
        return DeleteResponse.builder().message("Payroll deleted successfully").build();
    }

    @Override
    public PayrollDto getPayrollById(Long id) {
        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll not found"));
        return payrollMapper.toDto(payroll);
    }

    @Override
    public List<PayrollDto> getAllPayrolls() {
        return payrollMapper.toDtoList(payrollRepository.findAll());
    }

    @Override
    public List<PayrollDto> getPayrollsByEmployeeId(Long employeeId) {
        return payrollMapper.toDtoList(payrollRepository.findByEmployeeId(employeeId));
    }
}
