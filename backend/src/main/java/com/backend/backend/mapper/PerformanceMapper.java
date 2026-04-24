package com.backend.backend.mapper;

import com.backend.backend.model.Performance;
import com.backend.backend.payload.DTO.performanceDto.CreatePerformanceDto;
import com.backend.backend.payload.DTO.performanceDto.PerformanceDto;
import com.backend.backend.payload.DTO.performanceDto.UpdatePerformanceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PerformanceMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "reviewer", ignore = true)
    Performance toEntity(CreatePerformanceDto createPerformanceDto);

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(target = "employeeName", expression = "java(performance.getEmployee().getFirstName() + ' ' + performance.getEmployee().getLastName())")
    @Mapping(source = "reviewer.id", target = "reviewerId")
    @Mapping(target = "reviewerName", expression = "java(performance.getReviewer() != null ? performance.getReviewer().getFirstName() + ' ' + performance.getReviewer().getLastName() : null)")
    PerformanceDto toDto(Performance performance);

    List<PerformanceDto> toDtoList(List<Performance> performances);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "reviewer", ignore = true)
    @Mapping(target = "reviewDate", ignore = true)
    void updateEntityFromDto(UpdatePerformanceDto updatePerformanceDto, @MappingTarget Performance performance);
}
