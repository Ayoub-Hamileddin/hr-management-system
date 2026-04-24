package com.backend.backend.payload.DTO.attendanceDto;

import com.backend.backend.domain.AttendanceStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAttendanceDto {
    @NotNull(message = "Employee ID cannot be null")
    private Long employeeId;

    @NotNull(message = "Date cannot be null")
    private LocalDate date;

    private LocalTime checkIn;
    
    private LocalTime checkOut;

    @NotNull(message = "Status cannot be null")
    private AttendanceStatus status;
}
