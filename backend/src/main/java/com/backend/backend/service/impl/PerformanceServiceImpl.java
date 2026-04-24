package com.backend.backend.service.impl;

import com.backend.backend.Exceptions.ResourceNotFoundException;
import com.backend.backend.mapper.PerformanceMapper;
import com.backend.backend.model.Employee;
import com.backend.backend.model.Performance;
import com.backend.backend.payload.DTO.performanceDto.CreatePerformanceDto;
import com.backend.backend.payload.DTO.performanceDto.PerformanceDto;
import com.backend.backend.payload.DTO.performanceDto.UpdatePerformanceDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.repository.EmployeeRepository;
import com.backend.backend.repository.PerformanceRepository;
import com.backend.backend.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final EmployeeRepository employeeRepository;
    private final PerformanceMapper performanceMapper;

    @Override
    public PerformanceDto createPerformance(CreatePerformanceDto createPerformanceDto) {
        Employee employee = employeeRepository.findById(createPerformanceDto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Employee reviewer = null;
        if (createPerformanceDto.getReviewerId() != null) {
            reviewer = employeeRepository.findById(createPerformanceDto.getReviewerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Reviewer not found"));
        }

        Performance performance = performanceMapper.toEntity(createPerformanceDto);
        performance.setEmployee(employee);
        performance.setReviewer(reviewer);

        Performance savedPerformance = performanceRepository.save(performance);
        return performanceMapper.toDto(savedPerformance);
    }

    @Override
    public PerformanceDto updatePerformance(Long id, UpdatePerformanceDto updatePerformanceDto) {
        Performance performance = performanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Performance record not found"));

        performanceMapper.updateEntityFromDto(updatePerformanceDto, performance);
        Performance updatedPerformance = performanceRepository.save(performance);
        return performanceMapper.toDto(updatedPerformance);
    }

    @Override
    public DeleteResponse deletePerformance(Long id) {
        Performance performance = performanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Performance record not found"));

        performanceRepository.delete(performance);
        return DeleteResponse.builder().message("Performance record deleted successfully").build();
    }

    @Override
    public PerformanceDto getPerformanceById(Long id) {
        Performance performance = performanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Performance record not found"));
        return performanceMapper.toDto(performance);
    }

    @Override
    public List<PerformanceDto> getAllPerformances() {
        return performanceMapper.toDtoList(performanceRepository.findAll());
    }

    @Override
    public List<PerformanceDto> getPerformancesByEmployeeId(Long employeeId) {
        return performanceMapper.toDtoList(performanceRepository.findByEmployeeId(employeeId));
    }
}
