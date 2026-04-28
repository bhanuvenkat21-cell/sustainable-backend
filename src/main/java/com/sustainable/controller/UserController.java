package com.sustainable.controller;

import com.sustainable.model.User;
import com.sustainable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    // 🔹 REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        String result = userService.register(user);

        if (result.equals("Missing fields") || result.equals("User already exists")) {
            return ResponseEntity.badRequest().body(result);
        }

        return ResponseEntity.ok(Map.of(
                "message", result,
                "email", user.getEmail()
        ));
    }

    // 🔹 LOGIN (NO JWT)
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> data) {

        String email = data.get("email");
        String password = data.get("password");

        if (email == null || password == null) {
            return ResponseEntity.badRequest().body("Missing fields");
        }

        String result = userService.login(email, password);

        if (result.equals("User not found") || result.equals("Invalid password")) {
            return ResponseEntity.badRequest().body(result);
        }

        return ResponseEntity.ok(Map.of(
                "message", result,
                "email", email
        ));
    }
}