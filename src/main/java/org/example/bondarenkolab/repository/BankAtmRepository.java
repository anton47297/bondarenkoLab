package org.example.bondarenkolab.repository;

import org.example.bondarenkolab.entity.BankAtm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAtmRepository extends JpaRepository<BankAtm, Long> {
}