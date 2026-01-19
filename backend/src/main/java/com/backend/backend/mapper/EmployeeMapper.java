package com.backend.backend.mapper;

import com.backend.backend.model.Employee;
import com.backend.backend.payload.DTO.employeeDto.EmployeeDto;
import com.backend.backend.payload.DTO.employeeDto.UpdateEmployeeDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE= Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toDto(Employee employee);
    Employee toEntity(EmployeeDto employeeDto);


    @BeanMapping(nullValuePropertyMappingStrategy=NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromDto(
            UpdateEmployeeDto updateEmployeeDto,
            @MappingTarget Employee employee
    );
}
