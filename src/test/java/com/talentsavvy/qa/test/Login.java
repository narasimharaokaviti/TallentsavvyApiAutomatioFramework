package com.talentsavvy.qa.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.talentsavvy.config.ConstantReqestParameters;
import com.talentsavvy.qa.base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;

import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



@Listeners({com.talentsavvy.qa.test.Itestlistners.class})
public class Login extends Base {
	RequestSpecification httprequest;
	Response response;
	String responsebody;
	int responsecode;
	String statusline;
	Headers allheaders;
	JSONParser jsonp;
	FileReader reader;
	
	/*
	 * @Test public void getApi() {
	 * RestAssured.baseURI="https://reqres.in/api/users"; //RestAssured is
	 * represents a request object httprequest=RestAssured.given();
	 * httprequest.body("payloaddsata.json"); response=
	 * httprequest.request(Method.GET,"/api/users");
	 * responsebody=response.getBody().asString(); System.out.println(responsebody);
	 * 
	 * }
	 */
	
	
	@Test
	public void data() throws FileNotFoundException, IOException, ParseException {
		 jsonp=new JSONParser();
		try ( FileReader reader = new FileReader(prop.getProperty("jsonpath"))){
			Object  employeee=jsonp.parse(reader);
			RestAssured.baseURI=prop.getProperty("baseuri");
			httprequest=RestAssured.given();
			httprequest.body(employeee);
			response= httprequest.request(Method.POST,ConstantReqestParameters.apiusers);
			responsebody=response.getBody().asString();
			System.out.println(responsebody);
		    int code=	response.getStatusCode();
		    System.out.println(code);
		    
			}
				
			}	
	}
	 
			
	 

