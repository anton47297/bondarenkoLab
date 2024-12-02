package org.example.bondarenkolab.service.mapper;

import org.example.bondarenkolab.dto.PaymentAccountDto;
import org.example.bondarenkolab.entity.PaymentAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentAccountMapper {

    @Mapping(source = "bank.id", target = "bankId")
    @Mapping(source = "user.id", target = "userId")
    PaymentAccountDto toDto(PaymentAccount paymentAccount);

}