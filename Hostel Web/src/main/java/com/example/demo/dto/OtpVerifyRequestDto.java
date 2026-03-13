package com.example.demo.dto;

import com.example.demo.enums.OtpType;

import lombok.Data;

@Data
public class OtpVerifyRequestDto {
    private String email;
    private String mobile;
    private String otp;
    private OtpType type;
}
