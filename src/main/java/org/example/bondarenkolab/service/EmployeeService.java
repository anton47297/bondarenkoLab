package org.example.bondarenkolab.service;

import org.example.bondarenkolab.entity.Employee;

import java.time.LocalDate;

public interface EmployeeService {
    Employee createEmployee(String fullName, LocalDate birthDate, String position, Long bankId,
                            Boolean isRemote, Long bankOfficeId, Boolean canIssueLoans, Integer salary);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, String fullName, String position, Long bankId,
                            Boolean isRemote, Long bankOfficeId, Boolean canIssueLoans, Integer salary);

    void deleteEmployee(Long id);
}
