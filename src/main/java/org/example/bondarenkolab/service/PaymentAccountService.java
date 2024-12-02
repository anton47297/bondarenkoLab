package org.example.bondarenkolab.service;


import org.example.bondarenkolab.dto.PaymentAccountDto;
import org.example.bondarenkolab.entity.PaymentAccount;


public interface PaymentAccountService {
    PaymentAccountDto createPaymentAccount(Long userId, Long bankId);

    PaymentAccount getPaymentAccountById(Long id);

    PaymentAccountDto getPaymentAccountByIdDto(Long id);

    PaymentAccountDto updatePaymentAccount(Long id, Integer amount);

    void deletePaymentAccount(Long id);
}