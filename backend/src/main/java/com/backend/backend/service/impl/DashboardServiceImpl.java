package com.backend.backend.service.impl;

import com.backend.backend.domain.EmployeeStatus;
import com.backend.backend.payload.DTO.dashboardDto.DashboardStatsDto;
import com.backend.backend.repository.ApplicantRepository;
import com.backend.backend.repository.EmployeeRepository;
import com.backend.backend.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final EmployeeRepository employeeRepository;
    private final ApplicantRepository applicantRepository;

    @Override
    public DashboardStatsDto getDashboardStats() {
        long totalEmployees = employeeRepository.count();
        
        // Count new employees this month
        LocalDateTime startOfMonth = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0);
        long newEmployees = employeeRepository.findAll().stream()
                .filter(e -> e.getHireDate() != null && e.getHireDate().isAfter(startOfMonth))
                .count();

        // Resigned employees
        long resignedEmployees = employeeRepository.findAll().stream()
                .filter(e -> e.getStatus() == EmployeeStatus.INACTIVE)
                .count();

        return DashboardStatsDto.builder()
                .totalEmployees(totalEmployees)
                .jobApplicants(applicantRepository.count())
                .newEmployees(newEmployees)
                .resignedEmployees(resignedEmployees)
                .build();
    }
}
