package com.backend.backend.mapper;

import com.backend.backend.model.Attendance;
import com.backend.backend.payload.DTO.attendanceDto.AttendanceDto;
import com.backend.backend.payload.DTO.attendanceDto.CreateAttendanceDto;
import com.backend.backend.payload.DTO.attendanceDto.UpdateAttendanceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {
    @Mapping(target = "employee", ignore = true)
    Attendance toEntity(CreateAttendanceDto createAttendanceDto);

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(target = "employeeName", expression = "java(attendance.getEmployee().getFirstName() + ' ' + attendance.getEmployee().getLastName())")
    AttendanceDto toDto(Attendance attendance);

    List<AttendanceDto> toDtoList(List<Attendance> attendances);

    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)
    void updateEntityFromDto(UpdateAttendanceDto updateAttendanceDto, @MappingTarget Attendance attendance);
}
