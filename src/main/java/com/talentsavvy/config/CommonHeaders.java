package com.talentsavvy.config;

import java.util.HashMap;
import java.util.Map;

public class CommonHeaders {
	
	  public static Map<String, String> getHeaders() {
	        Map<String, String> headers = new HashMap<>();
	        headers.put("Content-Type", "application/json");
	        headers.put("H-CompId", "25");
	       
	        headers.put("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYW1lc2giLCJleHAiOjE2Nzg4MDg3MzYsImlhdCI6MTY3ODc5MDczNn0.vx1SRaKS9F4QkQy2ZXm7tn-SZ-hbt_rP-YSoBdKXhhsKNqme-Z_noD7QauDBshqELkGeiRGKDQRnWhn8aOAELQ");
	        return headers;
	    }

}
