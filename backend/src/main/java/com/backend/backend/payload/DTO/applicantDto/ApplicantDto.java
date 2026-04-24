package com.backend.backend.payload.DTO.applicantDto;

import com.backend.backend.domain.ApplicantStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String positionApplied;
    private ApplicantStatus status;
    private String resumeUrl;
    private LocalDate appliedDate;
}
