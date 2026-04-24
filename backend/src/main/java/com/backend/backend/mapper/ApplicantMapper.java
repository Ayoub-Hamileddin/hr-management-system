package com.backend.backend.mapper;

import com.backend.backend.model.Applicant;
import com.backend.backend.payload.DTO.applicantDto.ApplicantDto;
import com.backend.backend.payload.DTO.applicantDto.CreateApplicantDto;
import com.backend.backend.payload.DTO.applicantDto.UpdateApplicantDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "appliedDate", ignore = true)
    Applicant toEntity(CreateApplicantDto createApplicantDto);

    ApplicantDto toDto(Applicant applicant);

    List<ApplicantDto> toDtoList(List<Applicant> applicants);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "positionApplied", ignore = true)
    @Mapping(target = "resumeUrl", ignore = true)
    @Mapping(target = "appliedDate", ignore = true)
    void updateEntityFromDto(UpdateApplicantDto updateApplicantDto, @MappingTarget Applicant applicant);
}
