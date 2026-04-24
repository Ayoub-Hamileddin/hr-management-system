package com.backend.backend.service;

import com.backend.backend.payload.DTO.performanceDto.CreatePerformanceDto;
import com.backend.backend.payload.DTO.performanceDto.PerformanceDto;
import com.backend.backend.payload.DTO.performanceDto.UpdatePerformanceDto;
import com.backend.backend.payload.response.DeleteResponse;

import java.util.List;

public interface PerformanceService {
    PerformanceDto createPerformance(CreatePerformanceDto createPerformanceDto);
    PerformanceDto updatePerformance(Long id, UpdatePerformanceDto updatePerformanceDto);
    DeleteResponse deletePerformance(Long id);
    PerformanceDto getPerformanceById(Long id);
    List<PerformanceDto> getAllPerformances();
    List<PerformanceDto> getPerformancesByEmployeeId(Long employeeId);
}
