package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.serviceimpl.RazorpayServiceImpl;

import jakarta.persistence.criteria.Order;

public class PaymentController {
	
	@Autowired
	private RazorpayServiceImpl rezorpayServiceImpl;
	
	public PaymentController(RazorpayServiceImpl rezorpayServiceImpl) {
		this.rezorpayServiceImpl = rezorpayServiceImpl;
	}
	
	@PostMapping("/create-order")
	public String createOrder(@RequestParam Double amount) throws Exception {
		
		Order order = (Order) rezorpayServiceImpl.createOrder(amount);
		
		return order.toString();
		
	}

}
