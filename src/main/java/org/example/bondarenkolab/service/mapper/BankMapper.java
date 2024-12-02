package org.example.bondarenkolab.service.mapper;

import org.example.bondarenkolab.dto.BankDto;
import org.example.bondarenkolab.entity.Bank;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankMapper {

    BankDto toDto(Bank bank);

}