package org.example.bondarenkolab.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.bondarenkolab.entity.Bank;
import org.example.bondarenkolab.entity.BankOffice;
import org.example.bondarenkolab.entity.Employee;
import org.example.bondarenkolab.repository.BankRepository;
import org.example.bondarenkolab.repository.EmployeeRepository;
import org.example.bondarenkolab.service.BankOfficeService;
import org.example.bondarenkolab.service.BankService;
import org.example.bondarenkolab.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BankRepository bankRepository;
    private final BankService bankService;
    private final BankOfficeService bankOfficeService;

    @Override
    public Employee createEmployee(String fullName, LocalDate birthDate, String position, Long bankId,
                                   Boolean isRemote, Long bankOfficeId, Boolean canIssueLoans, Integer salary) {
        Employee employee = new Employee();
        employee.setFullName(fullName);
        employee.setBirthDate(birthDate);
        employee.setPosition(position);
        Bank bank = bankService.getBankById(bankId);
        bank.setCountEmployees(bank.getCountEmployees() + 1);
        employee.setBank(bank);
        employee.setIsRemote(isRemote);
        employee.setOffice(bankOfficeService.getBankOfficeById(bankOfficeId));
        employee.setCanIssueLoans(canIssueLoans);
        employee.setSalary(salary);
        bankRepository.save(bank);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    @Override
    public Employee updateEmployee(Long id, String fullName, String position, Long bankId,
                                   Boolean isRemote, Long bankOfficeId, Boolean canIssueLoans, Integer salary) {
        Employee employee = getEmployeeById(id);
        employee.setFullName(fullName);
        employee.setPosition(position);
        employee.setBank(bankService.getBankById(bankId));
        employee.setIsRemote(isRemote);
        employee.setOffice(bankOfficeService.getBankOfficeById(bankOfficeId));
        employee.setCanIssueLoans(canIssueLoans);
        employee.setSalary(salary);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        Bank bank = employee.getBank();
        bank.setCountEmployees(bank.getCountEmployees() - 1);
        bankRepository.save(bank);
        employeeRepository.deleteById(id);
    }
}