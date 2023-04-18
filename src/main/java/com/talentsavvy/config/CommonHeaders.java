package com.talentsavvy.config;

import java.util.HashMap;
import java.util.Map;

public class CommonHeaders {
	
	  public static Map<String, String> getHeaders() {
	        Map<String, String> headers = new HashMap<>();
	        headers.put("Content-Type", "application/json");
	        headers.put("Authorization", "");
	        return headers;
	    }

}
