package com.example.demo.serviceimpl;

import org.springframework.boot.jackson.JsonObjectDeserializer;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.criteria.Order;

public class RezorpayServiceImpl {
	
	private static final String KEY = "rzp_test_XXXXX";
	private static final String SECRET = "xxxxxxxx";
	
	public Order orderCreated(Double amount) throws RezorpayException {
		
		RezorpayClient cilent = new RezorpayClient(KEY, SECRET);
		
		JsonObject options = new Object();
		
		options.put("amount", amount*100);
		options.put("currency","INR");
		options.put("receipt", "txn_123456");
		
		return Client.orders.create(options);
		
	}

	public Order createOrder(Double amount) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
