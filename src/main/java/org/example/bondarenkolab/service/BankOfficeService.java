package org.example.bondarenkolab.service;

import org.example.bondarenkolab.entity.BankOffice;

import java.util.List;

public interface BankOfficeService {
    BankOffice createBankOffice(Long bankId, String name, String address, Boolean status,
                                Boolean canPlaceAtm, Boolean canIssueLoan, Boolean isIssuingMoney,
                                Boolean isDepositingMoney, Integer rentalCost);

    BankOffice getBankOfficeById(Long id);

    BankOffice updateBankOffice(Long id, Long bankId, String name, String address, Boolean status,
                                Boolean canPlaceAtm, Boolean canIssueLoan, Boolean isIssuingMoney,
                                Boolean isDepositingMoney, Integer rentalCost);

    void deleteBankOffice(Long id);

    List<BankOffice> getAllBankOffices();
}