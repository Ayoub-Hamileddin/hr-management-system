package com.backend.backend.service.impl;

import com.backend.backend.Exceptions.ResourceNotFoundException;
import com.backend.backend.domain.ApplicantStatus;
import com.backend.backend.mapper.ApplicantMapper;
import com.backend.backend.model.Applicant;
import com.backend.backend.payload.DTO.applicantDto.ApplicantDto;
import com.backend.backend.payload.DTO.applicantDto.CreateApplicantDto;
import com.backend.backend.payload.DTO.applicantDto.UpdateApplicantDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.repository.ApplicantRepository;
import com.backend.backend.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final ApplicantMapper applicantMapper;

    @Override
    public ApplicantDto createApplicant(CreateApplicantDto createApplicantDto) {
        Applicant applicant = applicantMapper.toEntity(createApplicantDto);
        applicant.setStatus(ApplicantStatus.NEW);
        applicant.setAppliedDate(LocalDate.now());

        Applicant savedApplicant = applicantRepository.save(applicant);
        return applicantMapper.toDto(savedApplicant);
    }

    @Override
    public ApplicantDto updateApplicantStatus(Long id, UpdateApplicantDto updateApplicantDto) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found"));

        applicantMapper.updateEntityFromDto(updateApplicantDto, applicant);
        Applicant updatedApplicant = applicantRepository.save(applicant);
        return applicantMapper.toDto(updatedApplicant);
    }

    @Override
    public DeleteResponse deleteApplicant(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found"));

        applicantRepository.delete(applicant);
        return DeleteResponse.builder().message("Applicant deleted successfully").build();
    }

    @Override
    public ApplicantDto getApplicantById(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found"));
        return applicantMapper.toDto(applicant);
    }

    @Override
    public List<ApplicantDto> getAllApplicants() {
        return applicantMapper.toDtoList(applicantRepository.findAll());
    }
}
