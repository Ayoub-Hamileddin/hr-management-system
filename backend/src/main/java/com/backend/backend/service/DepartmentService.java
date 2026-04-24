package com.backend.backend.service;

import com.backend.backend.payload.DTO.departmentDto.CreateDepartmentDto;
import com.backend.backend.payload.DTO.departmentDto.DepartmentDto;
import com.backend.backend.payload.DTO.departmentDto.UpdateDepartmentDto;
import com.backend.backend.payload.response.DeleteResponse;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(CreateDepartmentDto createDepartmentDto);
    DepartmentDto updateDepartment(Long id, UpdateDepartmentDto updateDepartmentDto);
    DeleteResponse deleteDepartment(Long id);
    DepartmentDto getDepartmentById(Long id);
    List<DepartmentDto> getAllDepartments();
}
