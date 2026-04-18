package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ForgotPasswordRequestDto;
import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.OtpVerifyRequestDto;
import com.example.demo.dto.ResetPasswordDto;
import com.example.demo.dto.SignupRequestDto;
import com.example.demo.entity.User;
import com.example.demo.enums.OtpType;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SmsService;
import com.example.demo.util.OtpUtil;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private com.example.demo.service.EmailService emailService;

	@Autowired
	private org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder passwordEncoder;


	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignupRequestDto request) {

	    if (!request.getPassword().equals(request.getConfirmPassword())) {
	        return ResponseEntity.badRequest()
	                .body(Map.of("success", false, "message", "Password is not matched "
	                		+ "."));
	    }

	    Optional<User> existing = userRepository.findByEmail(request.getEmail());
	    if (existing.isPresent()) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body(Map.of("success", false, "message", "Email already registered!"));
	    }

	    User user = new User();
	    user.setEmail(request.getEmail());
	    user.setMobile(request.getMobile());
	    user.setPassword(passwordEncoder.encode(request.getPassword()));
	    user.setRole(request.getRole());
	    
	    userRepository.save(user);
	    

	    String otp = com.example.demo.util.OtpUtil.generateOtp();
	    user.setOtp(otp);
	    user.setOtpExpiry(java.time.LocalDateTime.now().plusSeconds(60));
	    userRepository.save(user);
	   
	    
	    user.setEmailVerified(false);
	    user.setMobileVerified(false);
	    
	    String mobileOtp = OtpUtil.generateOtp();
	    user.setOtp(mobileOtp);
	    user.setOtpExpiry(LocalDateTime.now().plusSeconds(60));
	    userRepository.save(user);
	    SmsService.sendOtp(user.getMobile(), mobileOtp);

	    return ResponseEntity.ok(Map.of(
	            "success", true,
	            "message", "OTP sent to email and mobile"
	    ));

	}


	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {

	    Optional<User> optUser = userRepository.findByEmail(request.getEmail());

	    if (optUser.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(Map.of("success", false, "message", "Invalid email or password"));
	    }

	    User user = optUser.get();

	    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(Map.of("success", false, "message", "Invalid email or password"));
	    }


	    if (!user.getEmailVerified() && !user.getMobileVerified()) {
	        return ResponseEntity.status(HttpStatus.FORBIDDEN)
	            .body(Map.of(
	                "success", false,
	                "message", "Please verify email or mobile first"
	            ));
	    }


	    String token = com.example.demo.util.JwtUtil.generateToken(user.getEmail(), user.getRole());

	    return ResponseEntity.ok(Map.of(
	            "success", true,
	            "message", "Login successful",
	            "token", token,
	            "email", user.getEmail(),
	            "role", user.getRole()
	            
	    ));
	}

	
	@PostMapping("/verify-otp")
	public ResponseEntity<?> verifyOtp(@RequestBody OtpVerifyRequestDto request) {

	    User user;

	    if (request.getType() == OtpType.EMAIL) {
	        user = userRepository.findByEmail(request.getEmail())
	                .orElseThrow(() -> new RuntimeException("User not found"));
	    } else {
	        user = userRepository.findByMobile(request.getMobile())
	                .orElseThrow(() -> new RuntimeException("User not found"));
	    }

	    if (LocalDateTime.now().isAfter(user.getOtpExpiry())) {
	        return ResponseEntity.badRequest()
	                .body(Map.of("message", "OTP expired"));
	    }

	    if (!user.getOtp().equals(request.getOtp())) {
	        return ResponseEntity.badRequest()
	                .body(Map.of("message", "Invalid OTP"));
	    }

	    if (request.getType() == OtpType.EMAIL) {
	        user.setEmailVerified(true);
	    } else {
	        user.setMobileVerified(true);
	    }

	    user.setOtp(null);
	    user.setOtpExpiry(null);
	    userRepository.save(user);

	    return ResponseEntity.ok(Map.of(
	            "success", true,
	            "message", request.getType() + " verified successfully"
	    ));
	}

	
	@PostMapping("/resend-otp")
	public ResponseEntity<?> resendOtp(@RequestBody OtpVerifyRequestDto request) {

	    User user;

	    if (request.getType() == OtpType.EMAIL) {
	        user = userRepository.findByEmail(request.getEmail())
	                .orElseThrow(() -> new RuntimeException("User not found"));
	    } else {
	        user = userRepository.findByMobile(request.getMobile())
	                .orElseThrow(() -> new RuntimeException("User not found"));
	    }

	    String otp = OtpUtil.generateOtp();
	    user.setOtp(otp);
	    user.setOtpExpiry(LocalDateTime.now().plusSeconds(60));
	    userRepository.save(user);

	    if (request.getType() == OtpType.EMAIL) {
	        emailService.sendOtpEmail(user.getEmail(), otp);
	    } else {
	        SmsService.sendOtp(user.getMobile(), otp);
	    }

	    return ResponseEntity.ok(Map.of("message", "OTP resent"));
	}
	
	@PostMapping("/forgot-password")
	public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequestDto request) {

	    User user;

	    if ("EMAIL".equals(request.getType())) {
	        user = userRepository.findByEmail(request.getEmail())
	                .orElseThrow(() -> new RuntimeException("Email not registered"));
	    } else {
	        user = userRepository.findByMobile(request.getMobile())
	                .orElseThrow(() -> new RuntimeException("Mobile No not registered"));
	    }

	    String otp = OtpUtil.generateOtp();
	    user.setOtp(otp);
	    user.setOtpExpiry(LocalDateTime.now().plusSeconds(60));
	    userRepository.save(user);

	    if ("EMAIL".equals(request.getType())) {
	        emailService.sendOtpEmail(user.getEmail(), otp);
	    } else {
	        SmsService.sendOtp(user.getMobile(), otp);
	    }

	    return ResponseEntity.ok(Map.of(
	            "success", true,
	            "message", "OTP sent successfully"
	    ));
	}
	
	@PostMapping("/reset-password")
	public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordDto request) {

	    User user = request.getEmail() != null
	            ? userRepository.findByEmail(request.getEmail())
	                .orElseThrow(() -> new RuntimeException("User not found"))
	            : userRepository.findByMobile(request.getMobile())
	                .orElseThrow(() -> new RuntimeException("User not found"));

	    if (LocalDateTime.now().isAfter(user.getOtpExpiry())) {
	        return ResponseEntity.badRequest()
	                .body(Map.of("message", "OTP expired"));
	    }

	    if (!user.getOtp().equals(request.getOtp())) {
	        return ResponseEntity.badRequest()
	                .body(Map.of("message", "Invalid OTP"));
	    }

	    user.setPassword(passwordEncoder.encode(request.getNewPassword()));
	    user.setOtp(null);
	    user.setOtpExpiry(null);

	    userRepository.save(user);

	    return ResponseEntity.ok(Map.of(
	            "success", true,
	            "message", "Password reset successful"
	    ));
	}



}
