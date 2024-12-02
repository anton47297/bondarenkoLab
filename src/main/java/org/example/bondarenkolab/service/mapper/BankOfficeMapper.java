package org.example.bondarenkolab.service.mapper;

import org.example.bondarenkolab.dto.BankOfficeDto;
import org.example.bondarenkolab.entity.BankOffice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankOfficeMapper {

    @Mapping(source = "bank.name", target = "bankName")
    BankOfficeDto toDto(BankOffice bankOffice);

}