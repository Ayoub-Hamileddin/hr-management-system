package com.backend.backend.service.impl;

import com.backend.backend.Exceptions.ResourceNotFoundException;
import com.backend.backend.mapper.DepartmentMapper;
import com.backend.backend.model.Department;
import com.backend.backend.payload.DTO.departmentDto.CreateDepartmentDto;
import com.backend.backend.payload.DTO.departmentDto.DepartmentDto;
import com.backend.backend.payload.DTO.departmentDto.UpdateDepartmentDto;
import com.backend.backend.payload.response.DeleteResponse;
import com.backend.backend.repository.DepartmentRepository;
import com.backend.backend.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto createDepartment(CreateDepartmentDto createDepartmentDto) {
        Department department = departmentMapper.toEntity(createDepartmentDto);
        department.setCreatedAt(LocalDateTime.now());
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDto(savedDepartment);
    }

    @Override
    public DepartmentDto updateDepartment(Long id, UpdateDepartmentDto updateDepartmentDto) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        departmentMapper.updateEntityFromDto(updateDepartmentDto, department);
        Department updatedDepartment = departmentRepository.save(department);
        return departmentMapper.toDto(updatedDepartment);
    }

    @Override
    public DeleteResponse deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        departmentRepository.delete(department);
        return DeleteResponse.builder()
                .message("Department deleted successfully")
                .build();
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        return departmentMapper.toDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departmentMapper.toDtoList(departments);
    }
}
