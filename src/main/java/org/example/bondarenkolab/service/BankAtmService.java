package org.example.bondarenkolab.service;

import org.example.bondarenkolab.entity.BankAtm;

import java.util.List;

public interface BankAtmService {

    BankAtm createBankAtm(String name, String address, Boolean status, Long bankId,
                          Long bankOfficeId, Long employeeId, Boolean isIssuingMoney,
                          Boolean isDepositingMoney, Integer servicingCost);

    BankAtm getBankAtmById(Long id);

    BankAtm updateBankAtm(Long id, String name, String address, Boolean status, Long bankId,
                          Long bankOfficeId, Long employeeId, Boolean isIssuingMoney,
                          Boolean isDepositingMoney, Integer servicingCost);

    void deleteBankAtm(Long id);

    List<BankAtm> getAllBankAtms();
}