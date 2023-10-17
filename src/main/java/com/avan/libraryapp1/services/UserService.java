package com.avan.libraryapp1.services;

import com.avan.libraryapp1.model.User;
import com.avan.libraryapp1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve users: " + e.getMessage());
        }
    }

    public Optional<User> getUserById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid user ID.");
        }
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user: " + e.getMessage());
        }
    }

    public List<User> getUsersByRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role must not be empty.");
        }
        try {
            return userRepository.findByRole(role);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve users by role: " + e.getMessage());
        }
    }
    
    @Transactional
    public User saveUser(User user) {
        // Validate user details here if needed
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save user: " + e.getMessage());
        }
    }
    @Transactional
    public void deleteUser(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid user ID.");
        }
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete user: " + e.getMessage());
        }
    }

    public Optional<User> getUserByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be empty.");
        }
        try {
            return userRepository.findByEmail(email);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user by email: " + e.getMessage());
        }
    }

    public Optional<User> getUserByFirstNameAndLastName(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name and last name must not be empty.");
        }
        try {
            return userRepository.findByFirstNameAndLastName(firstName, lastName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user by name: " + e.getMessage());
        }
    }
}
