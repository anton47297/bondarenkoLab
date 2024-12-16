package org.example.bondarenkolab.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.bondarenkolab.entity.User;
import org.example.bondarenkolab.repository.UserRepository;
import org.example.bondarenkolab.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(String fullName, LocalDate birthDate, String workplace) {
        User user = new User();
        user.setFullName(fullName);
        user.setBirthDate(birthDate);
        user.setWorkplace(workplace);
        user.setMonthlyIncome((int)(Math.random() * 10_000));
        user.setCreditRating((user.getMonthlyIncome() / 1000) * 100);
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User repository not found with id " + id));
    }

    @Override
    public User updateUser(Long id, String fullName, String workplace) {
        User user = getUserById(id);
        user.setFullName(fullName);
        user.setWorkplace(workplace);
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Метод для получения всех пользователей
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}