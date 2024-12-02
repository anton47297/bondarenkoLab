package org.example.bondarenkolab.service;

import org.example.bondarenkolab.dto.CreditAccountDto;
import org.example.bondarenkolab.entity.CreditAccount;

import java.time.LocalDate;

public interface CreditAccountService {

    CreditAccountDto createCreditAccount(Long userId, Long bankId, LocalDate startDate, LocalDate endDate,
                                         Integer loanAmount, Float interestRate, Long issuingEmployeeId,
                                         Long paymentAccountId);

    CreditAccount getCreditAccountById(Long id);

    CreditAccountDto getCreditAccountByIdDto(Long id);

    CreditAccountDto updateCreditAccount(Long id, Long paymentAccountId);

    void deleteCreditAccount(Long id);
}
