package com.backend.backend.mapper;

import com.backend.backend.model.LeaveRequest;
import com.backend.backend.payload.DTO.leaveRequestDto.CreateLeaveRequestDto;
import com.backend.backend.payload.DTO.leaveRequestDto.LeaveRequestDto;
import com.backend.backend.payload.DTO.leaveRequestDto.UpdateLeaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LeaveRequestMapper {
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "status", ignore = true)
    LeaveRequest toEntity(CreateLeaveRequestDto createLeaveRequestDto);

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(target = "employeeName", expression = "java(leaveRequest.getEmployee().getFirstName() + ' ' + leaveRequest.getEmployee().getLastName())")
    LeaveRequestDto toDto(LeaveRequest leaveRequest);

    List<LeaveRequestDto> toDtoList(List<LeaveRequest> leaveRequests);

    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "startDate", ignore = true)
    @Mapping(target = "endDate", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "reason", ignore = true)
    void updateEntityFromDto(UpdateLeaveRequestDto updateLeaveRequestDto, @MappingTarget LeaveRequest leaveRequest);
}
