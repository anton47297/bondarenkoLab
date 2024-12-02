package org.example.bondarenkolab.service.mapper;

import org.example.bondarenkolab.dto.BankAtmDto;
import org.example.bondarenkolab.entity.BankAtm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankAtmMapper {

    @Mapping(source = "location.address", target = "locationAddress")
    @Mapping(source = "servicingEmployee.fullName", target = "servicingEmployeeName")
    @Mapping(source = "bank.name", target = "bankName")
    BankAtmDto toDto(BankAtm bankAtm);

}