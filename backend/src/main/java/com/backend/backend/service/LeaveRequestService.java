package com.backend.backend.service;

import com.backend.backend.payload.DTO.leaveRequestDto.CreateLeaveRequestDto;
import com.backend.backend.payload.DTO.leaveRequestDto.LeaveRequestDto;
import com.backend.backend.payload.DTO.leaveRequestDto.UpdateLeaveRequestDto;
import com.backend.backend.payload.response.DeleteResponse;

import java.util.List;

public interface LeaveRequestService {
    LeaveRequestDto createLeaveRequest(CreateLeaveRequestDto createLeaveRequestDto);
    LeaveRequestDto updateLeaveRequestStatus(Long id, UpdateLeaveRequestDto updateLeaveRequestDto);
    DeleteResponse deleteLeaveRequest(Long id);
    LeaveRequestDto getLeaveRequestById(Long id);
    List<LeaveRequestDto> getAllLeaveRequests();
    List<LeaveRequestDto> getLeaveRequestsByEmployeeId(Long employeeId);
}
