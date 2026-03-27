package com.example.demo.serviceimpl;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.json.JSONObject;



public class RazorpayServiceImpl {

    private static final String KEY = "rzp_test_XXXXX";
    private static final String SECRET = "xxxxxxxx";

    public Order orderCreated(Double amount) throws RazorpayException {

        RazorpayClient client = new RazorpayClient(KEY, SECRET);

        JSONObject options = new JSONObject();

        options.put("amount", amount * 100); 
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");

        return client.orders.create(options);
    }

    public Order createOrder(Double amount) {
        try {
            return orderCreated(amount);
        } catch (RazorpayException e) {
            e.printStackTrace();
            return null;
        }
    }
}