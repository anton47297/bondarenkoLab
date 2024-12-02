package org.example.bondarenkolab.service.mapper;

import org.example.bondarenkolab.dto.CreditAccountDto;
import org.example.bondarenkolab.entity.CreditAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditAccountMapper {

    @Mapping(source = "user.fullName", target = "userName")
    @Mapping(source = "bank.name", target = "bankName")
    @Mapping(source = "issuingEmployee.fullName", target = "issuingEmployeeName")
    @Mapping(source = "paymentAccount.amount", target = "paymentAccountAmount")
    CreditAccountDto toDto(CreditAccount creditAccount);

}