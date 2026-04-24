package com.backend.backend.service;

import com.backend.backend.payload.DTO.attendanceDto.AttendanceDto;
import com.backend.backend.payload.DTO.attendanceDto.CreateAttendanceDto;
import com.backend.backend.payload.DTO.attendanceDto.UpdateAttendanceDto;
import com.backend.backend.payload.response.DeleteResponse;

import java.util.List;

public interface AttendanceService {
    AttendanceDto createAttendance(CreateAttendanceDto createAttendanceDto);
    AttendanceDto updateAttendance(Long id, UpdateAttendanceDto updateAttendanceDto);
    DeleteResponse deleteAttendance(Long id);
    AttendanceDto getAttendanceById(Long id);
    List<AttendanceDto> getAllAttendances();
    List<AttendanceDto> getAttendancesByEmployeeId(Long employeeId);
}
