package com.example.demo.serviceimpl;

import org.springframework.stereotype.Service;


@Service
public class SmsServiceImpl {
	
	public void sendOtp(String mobile, String otp) {
		
		System.out.println("Sending OTP"+ otp + "to mobile" + mobile);
	}

}
