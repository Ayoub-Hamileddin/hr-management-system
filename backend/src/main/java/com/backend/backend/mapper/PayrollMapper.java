package com.backend.backend.mapper;

import com.backend.backend.model.Payroll;
import com.backend.backend.payload.DTO.payrollDto.CreatePayrollDto;
import com.backend.backend.payload.DTO.payrollDto.PayrollDto;
import com.backend.backend.payload.DTO.payrollDto.UpdatePayrollDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PayrollMapper {
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "netSalary", ignore = true)
    @Mapping(target = "paymentDate", ignore = true)
    Payroll toEntity(CreatePayrollDto createPayrollDto);

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(target = "employeeName", expression = "java(payroll.getEmployee().getFirstName() + ' ' + payroll.getEmployee().getLastName())")
    PayrollDto toDto(Payroll payroll);

    List<PayrollDto> toDtoList(List<Payroll> payrolls);

    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "month", ignore = true)
    @Mapping(target = "year", ignore = true)
    @Mapping(target = "baseSalary", ignore = true)
    @Mapping(target = "deductions", ignore = true)
    @Mapping(target = "bonuses", ignore = true)
    @Mapping(target = "netSalary", ignore = true)
    @Mapping(target = "paymentDate", ignore = true)
    void updateEntityFromDto(UpdatePayrollDto updatePayrollDto, @MappingTarget Payroll payroll);
}
