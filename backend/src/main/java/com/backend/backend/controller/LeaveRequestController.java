package com.backend.backend.controller;

import com.backend.backend.payload.DTO.leaveRequestDto.CreateLeaveRequestDto;
import com.backend.backend.payload.DTO.leaveRequestDto.LeaveRequestDto;
import com.backend.backend.payload.DTO.leaveRequestDto.UpdateLeaveRequestDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.service.LeaveRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeoff")
@RequiredArgsConstructor
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LeaveRequestDto> createLeaveRequest(@Valid @RequestBody CreateLeaveRequestDto createLeaveRequestDto) {
        return ResponseEntity.ok(leaveRequestService.createLeaveRequest(createLeaveRequestDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LeaveRequestDto> updateLeaveRequestStatus(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateLeaveRequestDto updateLeaveRequestDto) {
        return ResponseEntity.ok(leaveRequestService.updateLeaveRequestStatus(id, updateLeaveRequestDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DeleteResponse> deleteLeaveRequest(@PathVariable("id") Long id) {
        return ResponseEntity.ok(leaveRequestService.deleteLeaveRequest(id));
    }

    @GetMapping
    public ResponseEntity<List<LeaveRequestDto>> getAllLeaveRequests() {
        return ResponseEntity.ok(leaveRequestService.getAllLeaveRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequestDto> getLeaveRequestById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(leaveRequestService.getLeaveRequestById(id));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<LeaveRequestDto>> getLeaveRequestsByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        return ResponseEntity.ok(leaveRequestService.getLeaveRequestsByEmployeeId(employeeId));
    }
}
