package org.example.bondarenkolab.repository;

import org.example.bondarenkolab.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}