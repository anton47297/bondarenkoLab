package org.example.bondarenkolab.service;


import org.example.bondarenkolab.entity.PaymentAccount;


public interface PaymentAccountService {
    PaymentAccount createPaymentAccount(Long userId, Long bankId);

    PaymentAccount getPaymentAccountById(Long id);

    PaymentAccount updatePaymentAccount(Long id, Integer amount);

    void deletePaymentAccount(Long id);
}