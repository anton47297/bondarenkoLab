package org.example.bondarenkolab.service;

import org.example.bondarenkolab.entity.Bank;

public interface BankService {

    Bank createBank(String bankName);

    Bank getBankById(Long id);

    Bank updateBank(Long id, String name);

    void deleteBank(Long id);
}