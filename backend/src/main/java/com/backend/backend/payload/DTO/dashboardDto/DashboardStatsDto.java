package com.backend.backend.payload.DTO.dashboardDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DashboardStatsDto {
    private long totalEmployees;
    private long jobApplicants;
    private long newEmployees;
    private long resignedEmployees;
}
