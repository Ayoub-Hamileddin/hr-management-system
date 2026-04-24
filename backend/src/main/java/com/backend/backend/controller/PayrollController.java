package com.backend.backend.controller;

import com.backend.backend.payload.DTO.payrollDto.CreatePayrollDto;
import com.backend.backend.payload.DTO.payrollDto.PayrollDto;
import com.backend.backend.payload.DTO.payrollDto.UpdatePayrollDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.service.PayrollService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
@RequiredArgsConstructor
public class PayrollController {

    private final PayrollService payrollService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PayrollDto> createPayroll(@Valid @RequestBody CreatePayrollDto createPayrollDto) {
        return ResponseEntity.ok(payrollService.createPayroll(createPayrollDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PayrollDto> updatePayrollStatus(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdatePayrollDto updatePayrollDto) {
        return ResponseEntity.ok(payrollService.updatePayrollStatus(id, updatePayrollDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeleteResponse> deletePayroll(@PathVariable("id") Long id) {
        return ResponseEntity.ok(payrollService.deletePayroll(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PayrollDto>> getAllPayrolls() {
        return ResponseEntity.ok(payrollService.getAllPayrolls());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PayrollDto> getPayrollById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(payrollService.getPayrollById(id));
    }

    @GetMapping("/employee/{employeeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PayrollDto>> getPayrollsByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        return ResponseEntity.ok(payrollService.getPayrollsByEmployeeId(employeeId));
    }
}
