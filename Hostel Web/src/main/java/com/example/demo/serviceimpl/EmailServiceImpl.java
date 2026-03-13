package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendOtpEmail(String toEmail, String otp) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("HMS Email Verification OTP");
            message.setText("Your OTP is: " + otp + "\nOTP valid for 60 seconds.");

            mailSender.send(message);
            System.out.println("✅ OTP Email sent to: " + toEmail);

        } catch (Exception e) {
            System.out.println("❌ Mail Error: ");
            e.printStackTrace();  // this shows real error in console
        }
    }
}
