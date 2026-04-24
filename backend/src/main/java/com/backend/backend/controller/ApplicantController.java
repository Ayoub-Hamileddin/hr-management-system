package com.backend.backend.controller;

import com.backend.backend.payload.DTO.applicantDto.ApplicantDto;
import com.backend.backend.payload.DTO.applicantDto.CreateApplicantDto;
import com.backend.backend.payload.DTO.applicantDto.UpdateApplicantDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.service.ApplicantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@RequiredArgsConstructor
public class ApplicantController {

    private final ApplicantService applicantService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApplicantDto> createApplicant(@Valid @RequestBody CreateApplicantDto createApplicantDto) {
        return ResponseEntity.ok(applicantService.createApplicant(createApplicantDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApplicantDto> updateApplicantStatus(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateApplicantDto updateApplicantDto) {
        return ResponseEntity.ok(applicantService.updateApplicantStatus(id, updateApplicantDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeleteResponse> deleteApplicant(@PathVariable("id") Long id) {
        return ResponseEntity.ok(applicantService.deleteApplicant(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ApplicantDto>> getAllApplicants() {
        return ResponseEntity.ok(applicantService.getAllApplicants());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApplicantDto> getApplicantById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(applicantService.getApplicantById(id));
    }
}
