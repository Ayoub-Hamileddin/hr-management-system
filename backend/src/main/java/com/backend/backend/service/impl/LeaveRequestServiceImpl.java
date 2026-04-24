package com.backend.backend.service.impl;

import com.backend.backend.Exceptions.ResourceNotFoundException;
import com.backend.backend.domain.LeaveStatus;
import com.backend.backend.mapper.LeaveRequestMapper;
import com.backend.backend.model.Employee;
import com.backend.backend.model.LeaveRequest;
import com.backend.backend.payload.DTO.leaveRequestDto.CreateLeaveRequestDto;
import com.backend.backend.payload.DTO.leaveRequestDto.LeaveRequestDto;
import com.backend.backend.payload.DTO.leaveRequestDto.UpdateLeaveRequestDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.repository.EmployeeRepository;
import com.backend.backend.repository.LeaveRequestRepository;
import com.backend.backend.service.LeaveRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;
    private final LeaveRequestMapper leaveRequestMapper;

    @Override
    public LeaveRequestDto createLeaveRequest(CreateLeaveRequestDto createLeaveRequestDto) {
        Employee employee = employeeRepository.findById(createLeaveRequestDto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        LeaveRequest leaveRequest = leaveRequestMapper.toEntity(createLeaveRequestDto);
        leaveRequest.setEmployee(employee);
        leaveRequest.setStatus(LeaveStatus.PENDING);

        LeaveRequest savedRequest = leaveRequestRepository.save(leaveRequest);
        return leaveRequestMapper.toDto(savedRequest);
    }

    @Override
    public LeaveRequestDto updateLeaveRequestStatus(Long id, UpdateLeaveRequestDto updateLeaveRequestDto) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found"));

        leaveRequestMapper.updateEntityFromDto(updateLeaveRequestDto, leaveRequest);
        LeaveRequest updatedRequest = leaveRequestRepository.save(leaveRequest);
        return leaveRequestMapper.toDto(updatedRequest);
    }

    @Override
    public DeleteResponse deleteLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found"));
        leaveRequestRepository.delete(leaveRequest);
        return DeleteResponse.builder().message("Leave request deleted successfully").build();
    }

    @Override
    public LeaveRequestDto getLeaveRequestById(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found"));
        return leaveRequestMapper.toDto(leaveRequest);
    }

    @Override
    public List<LeaveRequestDto> getAllLeaveRequests() {
        return leaveRequestMapper.toDtoList(leaveRequestRepository.findAll());
    }

    @Override
    public List<LeaveRequestDto> getLeaveRequestsByEmployeeId(Long employeeId) {
        return leaveRequestMapper.toDtoList(leaveRequestRepository.findByEmployeeId(employeeId));
    }
}
