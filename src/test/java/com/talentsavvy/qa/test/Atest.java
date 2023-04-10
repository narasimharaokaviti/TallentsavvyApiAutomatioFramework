package com.talentsavvy.qa.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.talentsavvy.config.ConstantReqestParameters;
import com.talentsavvy.qa.base.Base;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
@Listeners({com.talentsavvy.qa.test.Itestlistners.class})
public class Atest extends Base {
	RequestSpecification httprequest;
	Response response;
	String responsebody;
	int responsecode;
	String statusline;
	JSONParser jsonp;
	FileReader reader;
	File jsonfile;
	Object data;
	@Test
	public void verifyCreateUserAPiTest( ) throws IOException,FileNotFoundException {
		jsonResource("employee");
		RestAssured.baseURI=prop.getProperty("baseuri");
		httprequest=RestAssured.given();
		httprequest.body(data);
		System.out.println(data);
		response= httprequest.request(Method.POST,ConstantReqestParameters.apiusers);
		responsebody=response.getBody().asString();
		System.out.println(responsebody);
		int code=	response.getStatusCode();
		System.out.println(code);	
	}
	
	
	public void jsonResource(String element) throws IOException { 
		jsonfile= new File(prop.getProperty("jsonpath"));
		data=JsonPath.read(jsonfile,"$."+element);

	}
	 
	 
	/*
	 * File jsonfile= new File(prop.getProperty("jsonpath")); Object
	 * data=JsonPath.read(jsonfile,"$."+"employeeee");
	 */
	
	
	
	/*
	 * jsonfile= new File(prop.getProperty("jsonpath"));
	 * data=JsonPath.read(jsonfile,"$."+"employeeee");
	 */
}
