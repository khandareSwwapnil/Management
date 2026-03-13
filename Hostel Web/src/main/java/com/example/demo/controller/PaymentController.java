package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.serviceimpl.RezorpayServiceImpl;

import jakarta.persistence.criteria.Order;

public class PaymentController {
	
	@Autowired
	private RezorpayServiceImpl rezorpayServiceImpl;
	
	public PaymentController(RezorpayServiceImpl rezorpayServiceImpl) {
		this.rezorpayServiceImpl = rezorpayServiceImpl;
	}
	
	@PostMapping("/create-order")
	public String createOrder(@RequestParam Double amount) throws Exception {
		
		Order order = rezorpayServiceImpl.createOrder(amount);
		
		return order.toString();
		
	}

}
