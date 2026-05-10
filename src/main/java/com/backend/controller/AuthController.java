package com.backend.controller;

import com.backend.config.JwtUtil;
import com.backend.dto.AuthResponse;
import com.backend.dto.LoginRequest;
import com.backend.entity.User;
import com.backend.entity.Vendor;
import com.backend.repository.UserRepository;
import com.backend.repository.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // CUSTOMER SIGNUP
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {

        user.setRole("CUSTOMER");

        return userRepository.save(user);
    }

    // CUSTOMER LOGIN
    @PostMapping("/customer/login")
    public AuthResponse customerLogin(
            @RequestBody LoginRequest request
    ) {

        User user = userRepository
                .findByPhone(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"
                        )
                );

        String token =
                jwtUtil.generateToken(
                        user.getPhone()
                );

        return new AuthResponse(token);
    }

    // VENDOR LOGIN
    @PostMapping("/vendor/login")
    public AuthResponse vendorLogin(
            @RequestBody LoginRequest request
    ) {

        Vendor vendor = vendorRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Vendor not found"
                        )
                );

        if (!vendor.getPassword()
                .equals(request.getPassword())) {

            throw new RuntimeException(
                    "Invalid password"
            );
        }

        String token =
                jwtUtil.generateToken(
                        vendor.getEmail()
                );

        return new AuthResponse(token);
    }
}