package com.backend.backend.payload.DTO.applicantDto;

import com.backend.backend.domain.ApplicantStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantDto {
    @NotNull(message = "Status cannot be null")
    private ApplicantStatus status;
}
