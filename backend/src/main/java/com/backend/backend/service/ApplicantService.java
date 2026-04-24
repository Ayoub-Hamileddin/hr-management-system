package com.backend.backend.service;

import com.backend.backend.payload.DTO.applicantDto.ApplicantDto;
import com.backend.backend.payload.DTO.applicantDto.CreateApplicantDto;
import com.backend.backend.payload.DTO.applicantDto.UpdateApplicantDto;
import com.backend.backend.payload.response.DeleteResponse;

import java.util.List;

public interface ApplicantService {
    ApplicantDto createApplicant(CreateApplicantDto createApplicantDto);
    ApplicantDto updateApplicantStatus(Long id, UpdateApplicantDto updateApplicantDto);
    DeleteResponse deleteApplicant(Long id);
    ApplicantDto getApplicantById(Long id);
    List<ApplicantDto> getAllApplicants();
}
