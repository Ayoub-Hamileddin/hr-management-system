package com.backend.backend.payload.DTO.leaveRequestDto;

import com.backend.backend.domain.LeaveStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLeaveRequestDto {
    @NotNull(message = "Status cannot be null")
    private LeaveStatus status;
}
