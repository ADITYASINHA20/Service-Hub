package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtpEmail(
            String toEmail,
            String otp
    ) {

        try {

            SimpleMailMessage message =
                    new SimpleMailMessage();

            message.setTo(toEmail);

            message.setFrom(
                    "adityarajkyp11012006@gmail.com"
            );

            message.setSubject(
                    "OTP Verification"
            );

            message.setText(
                    "Your OTP is: " + otp
            );

            mailSender.send(message);

            System.out.println(
                    "MAIL SENT SUCCESSFULLY"
            );

        } catch (Exception e) {

            System.out.println(
                    "MAIL ERROR"
            );

            e.printStackTrace();
        }

    }
}