package com.talentsavvy.config;

import java.util.HashMap;
import java.util.Map;

public class CommonHeaders {
	
	  public static Map<String, String> getHeaders() {
	        Map<String, String> headers = new HashMap<>();
	       // headers.put("Postman-Token", "calculated when request is sent");
	       // headers.put("Host", "<calculcated when request is sent>");
	        headers.put("Accept", "*/*");
	        headers.put("Accept-Encoding", "gzip, deflate, br");
	        headers.put("Connections", "keep-alive");
	        headers.put("Content-Type", "application/json");
	      
	       
	        return headers;
	    }

}
