package com.backend.backend.mapper;

import com.backend.backend.model.Department;
import com.backend.backend.payload.DTO.departmentDto.CreateDepartmentDto;
import com.backend.backend.payload.DTO.departmentDto.DepartmentDto;
import com.backend.backend.payload.DTO.departmentDto.UpdateDepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(CreateDepartmentDto createDepartmentDto);
    DepartmentDto toDto(Department department);
    List<DepartmentDto> toDtoList(List<Department> departments);
    void updateEntityFromDto(UpdateDepartmentDto updateDepartmentDto, @MappingTarget Department department);
}
