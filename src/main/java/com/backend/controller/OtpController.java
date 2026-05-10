package com.backend.controller;

import com.backend.dto.OtpRequest;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/otp")
@CrossOrigin("*")

public class OtpController {

    private Map<String, String> otpStore =
            new HashMap<>();

    // SEND OTP
    @PostMapping("/send")
    public String sendOtp(

            @RequestBody
            OtpRequest request

    ) {

        String otp =
                String.valueOf(

                        100000 +
                        new Random().nextInt(900000)

                );

        otpStore.put(
                request.getEmail(),
                otp
        );

        // OTP PRINT IN CONSOLE
        System.out.println(
                "OTP : " + otp
        );

        return "OTP Sent Successfully";
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