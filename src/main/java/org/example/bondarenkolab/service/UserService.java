package org.example.bondarenkolab.service;

import org.example.bondarenkolab.entity.User;

import java.time.LocalDate;

public interface UserService {
    User createUser(String fullName, LocalDate birthDate, String workplace);

    User getUserById(Long id);

    User updateUser(Long id, String fullName, String workplace);

    void deleteUser(Long id);
}
