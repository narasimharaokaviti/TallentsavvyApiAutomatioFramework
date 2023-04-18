package com.talentsavvy.config;

import org.json.simple.JSONObject;

public class PayLoadData {
	public static Object userApi() {
		JSONObject request=new JSONObject();
		request.put("name","narasimha");
		request.put("id","23");
		request.put("role","qa ");
		return request; 
	} 

}
