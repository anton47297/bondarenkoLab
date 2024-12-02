package org.example.bondarenkolab.service.mapper;

import org.example.bondarenkolab.dto.EmployeeDto;
import org.example.bondarenkolab.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "bank.name", target = "bankName")
    @Mapping(source = "office.name", target = "officeName")
    EmployeeDto toDto(Employee employee);

}