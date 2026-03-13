package com.example.demo.util;

import java.time.Year;

public class InvoiceNumberGenerator {
	
	  public static String generate() {
	        String year = String.valueOf(Year.now().getValue());
	        long random = (long) (Math.random() * 9000) + 1000;
	        return "INV-" + year + "-" + random;
	    }

}
