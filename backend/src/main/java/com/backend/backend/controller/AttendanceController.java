package com.backend.backend.controller;

import com.backend.backend.payload.DTO.attendanceDto.AttendanceDto;
import com.backend.backend.payload.DTO.attendanceDto.CreateAttendanceDto;
import com.backend.backend.payload.DTO.attendanceDto.UpdateAttendanceDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AttendanceDto> createAttendance(@Valid @RequestBody CreateAttendanceDto createAttendanceDto) {
        return ResponseEntity.ok(attendanceService.createAttendance(createAttendanceDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AttendanceDto> updateAttendance(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateAttendanceDto updateAttendanceDto) {
        return ResponseEntity.ok(attendanceService.updateAttendance(id, updateAttendanceDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeleteResponse> deleteAttendance(@PathVariable("id") Long id) {
        return ResponseEntity.ok(attendanceService.deleteAttendance(id));
    }

    @GetMapping
    public ResponseEntity<List<AttendanceDto>> getAllAttendances() {
        return ResponseEntity.ok(attendanceService.getAllAttendances());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceDto> getAttendanceById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(attendanceService.getAttendanceById(id));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<AttendanceDto>> getAttendancesByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        return ResponseEntity.ok(attendanceService.getAttendancesByEmployeeId(employeeId));
    }
}
