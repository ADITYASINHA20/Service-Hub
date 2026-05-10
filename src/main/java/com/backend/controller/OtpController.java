package com.backend.controller;

import com.backend.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/otp")
@CrossOrigin("*")

public class OtpController {

    @Autowired
    private EmailService emailService;

    private Map<String, String> otpStore =
            new HashMap<>();

    // SEND OTP
    @PostMapping("/send")
    public ResponseEntity<?> sendOtp(
            @RequestParam String email
    ) {

        String otp =
                String.valueOf(
                        100000 +
                        new Random().nextInt(900000)
                );

        otpStore.put(email, otp);

        System.out.println(
                "OTP : " + otp
        );

        // SEND MAIL IN BACKGROUND
        new Thread(() -> {

            try {

                emailService.sendOtpEmail(
                        email,
                        otp
                );

            } catch (Exception e) {

                e.printStackTrace();

            }

        }).start();

        return ResponseEntity.ok(
                "OTP Sent Successfully"
        );
    }

    // VERIFY OTP
    @PostMapping("/verify")
    public String verifyOtp(

            @RequestParam String email,

            @RequestParam String otp

    ) {

        String storedOtp =
                otpStore.get(email);

        if (

                storedOtp != null &&

                storedOtp.equals(otp)

        ) {

            otpStore.remove(email);

            return "OTP Verified";
        }

        return "Invalid OTP";
    }
}