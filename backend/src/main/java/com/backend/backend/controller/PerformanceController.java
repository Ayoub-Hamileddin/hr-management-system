package com.backend.backend.controller;

import com.backend.backend.payload.DTO.performanceDto.CreatePerformanceDto;
import com.backend.backend.payload.DTO.performanceDto.PerformanceDto;
import com.backend.backend.payload.DTO.performanceDto.UpdatePerformanceDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.service.PerformanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
@RequiredArgsConstructor
public class PerformanceController {

    private final PerformanceService performanceService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PerformanceDto> createPerformance(@Valid @RequestBody CreatePerformanceDto createPerformanceDto) {
        return ResponseEntity.ok(performanceService.createPerformance(createPerformanceDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PerformanceDto> updatePerformance(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdatePerformanceDto updatePerformanceDto) {
        return ResponseEntity.ok(performanceService.updatePerformance(id, updatePerformanceDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeleteResponse> deletePerformance(@PathVariable("id") Long id) {
        return ResponseEntity.ok(performanceService.deletePerformance(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PerformanceDto>> getAllPerformances() {
        return ResponseEntity.ok(performanceService.getAllPerformances());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PerformanceDto> getPerformanceById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(performanceService.getPerformanceById(id));
    }

    @GetMapping("/employee/{employeeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PerformanceDto>> getPerformancesByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        return ResponseEntity.ok(performanceService.getPerformancesByEmployeeId(employeeId));
    }
}
