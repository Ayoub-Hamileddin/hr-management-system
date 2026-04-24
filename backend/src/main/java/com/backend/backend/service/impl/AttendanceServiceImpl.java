package com.backend.backend.service.impl;

import com.backend.backend.Exceptions.ResourceNotFoundException;
import com.backend.backend.mapper.AttendanceMapper;
import com.backend.backend.model.Attendance;
import com.backend.backend.model.Employee;
import com.backend.backend.payload.DTO.attendanceDto.AttendanceDto;
import com.backend.backend.payload.DTO.attendanceDto.CreateAttendanceDto;
import com.backend.backend.payload.DTO.attendanceDto.UpdateAttendanceDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.repository.AttendanceRepository;
import com.backend.backend.repository.EmployeeRepository;
import com.backend.backend.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;
    private final AttendanceMapper attendanceMapper;

    @Override
    public AttendanceDto createAttendance(CreateAttendanceDto createAttendanceDto) {
        Employee employee = employeeRepository.findById(createAttendanceDto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Attendance attendance = attendanceMapper.toEntity(createAttendanceDto);
        attendance.setEmployee(employee);

        Attendance savedAttendance = attendanceRepository.save(attendance);
        return attendanceMapper.toDto(savedAttendance);
    }

    @Override
    public AttendanceDto updateAttendance(Long id, UpdateAttendanceDto updateAttendanceDto) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance record not found"));

        attendanceMapper.updateEntityFromDto(updateAttendanceDto, attendance);
        Attendance updatedAttendance = attendanceRepository.save(attendance);
        return attendanceMapper.toDto(updatedAttendance);
    }

    @Override
    public DeleteResponse deleteAttendance(Long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance record not found"));
        
        attendanceRepository.delete(attendance);
        return DeleteResponse.builder()
                .message("Attendance record deleted successfully")
                .build();
    }

    @Override
    public AttendanceDto getAttendanceById(Long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance record not found"));
        return attendanceMapper.toDto(attendance);
    }

    @Override
    public List<AttendanceDto> getAllAttendances() {
        return attendanceMapper.toDtoList(attendanceRepository.findAll());
    }

    @Override
    public List<AttendanceDto> getAttendancesByEmployeeId(Long employeeId) {
        return attendanceMapper.toDtoList(attendanceRepository.findByEmployeeId(employeeId));
    }
}
