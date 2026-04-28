package com.sustainable.service;

import com.sustainable.model.User;
import com.sustainable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 🔹 REGISTER (NO ENCRYPTION)
    public String register(User user) {

        if (user.getEmail() == null || user.getName() == null || user.getPassword() == null) {
            return "Missing fields";
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "User already exists";
        }

        // ❌ NO ENCRYPTION
        user.setPassword(user.getPassword());

        userRepository.save(user);

        return "User registered successfully";
    }

    // 🔹 LOGIN (SIMPLE CHECK)
    public String login(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            return "User not found";
        }

        User user = userOptional.get();

        // ❌ SIMPLE PASSWORD CHECK
        if (!password.equals(user.getPassword())) {
            return "Invalid password";
        }

        return "Login successful";
    }
}