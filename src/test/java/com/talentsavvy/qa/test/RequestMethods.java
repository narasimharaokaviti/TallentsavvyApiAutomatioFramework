package com.talentsavvy.qa.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.talentsavvy.config.ConstantReqestParameters;
import com.talentsavvy.qa.base.Base;
import com.talentsavvy.qa.base.ResponseActions;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestMethods extends Base {
	
	static RequestSpecification httprequest;
	 static Response response;
	static String responsebody;
	static io.restassured.path.json.JsonPath path;
	JSONParser jsonp;
	FileReader reader;
	static File jsonfile;
	static Object data;
	static Logger loger = LogManager.getLogger(RequestMethods.class);
	
	public static void jsonResource(String element) throws IOException { 
		jsonfile= new File(prop.getProperty("jsonpath"));
		data=JsonPath.read(jsonfile,"$."+element);
	}
	
	public static void PostparameterRequest(String name) {
		
		RestAssured.baseURI=prop.getProperty("baseuri");
		//Rest Assured is the request object.
		loger.info("Rest Assured is the request object.");		
		httprequest=RestAssured.given();
		//This line represents we can provide a payload data in json format
		httprequest.body(data);
		//print json data in console
		System.out.println(data);
		//Now we can create a response object and provide a request type to provide a path parameter with the request.
		try {
			response= httprequest.request(Method.POST,name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	
		//asString represents  whole response body converted into string format then we can able to see in console
		responsebody=response.getBody().asString();
		System.out.println("Responce body is "+responsebody);
		//path=response.jsonPath();
		//Assert.assertEquals(response.getStatusCode(),ResponseActions.isStatusPostRequestSucessCodeDisplayed(),"status code sucess");
		//System.out.println(path.get("status"));
		//Assert.assertEquals(response.getStatusLine(),this.isStatuslineDisplayed());
		
	}
	public static void PutparameterRequest(String name) {
		RestAssured.baseURI=prop.getProperty("baseuri");
		//Rest Assured is the request object.
		httprequest=RestAssured.given();
		//This line represents we can provide a payload data in json format
		httprequest.body(data);
		//print json data in console
		System.out.println(data);
		//Now we can create a response object and provide a request type to provide a path parameter with the request.
		response= httprequest.request(Method.PUT,name);
		//asString represents  whole response body converted into string format then we can able to see in console
		responsebody=response.getBody().asString();
		System.out.println(responsebody);
		path=response.jsonPath();
		Assert.assertEquals(response.getStatusCode(),ResponseActions.isPutRequestSucessCodeDisplayed());
		//System.out.println(path.get("status"));
		//Assert.assertEquals(response.getStatusLine(),this.isStatuslineDisplayed());
		
	}
	public static  void getParameterRequest(String name) {
		RestAssured.baseURI=prop.getProperty("baseuri");
		//Rest Assured is the request object.
		httprequest=RestAssured.given();
		//Now we can create a response object and provide a request type to provide a path parameter with the request.
		response= httprequest.request(Method.GET,name);
		//asString represents  whole response body converted into string format then we can able to see in console
		responsebody=response.getBody().asString();
		System.out.println(responsebody);
		Assert.assertEquals(response.getStatusCode(),ResponseActions.isGetRequestSucessCodeDisplayed());
	}
	public static  void deleteParameterRequest(String name) {
		RestAssured.baseURI=prop.getProperty("baseuri");
		//Rest Assured is the request object.
		httprequest=RestAssured.given();
		//Now we can create a response object and provide a request type to provide a path parameter with the request.
		response= httprequest.request(Method.DELETE,name);
		//asString represents  whole response body converted into string format then we can able to see in console
		responsebody=response.getBody().asString();
		System.out.println(responsebody);
	}

	@Test(priority=0,description="This testcase verifies creata a user",enabled=true)
	public void verifyCreateUserApi() throws IOException {
		 //this method represent getting payload data in json format
		jsonResource("employee1");
		//RequestSpecification is a predefined class imported from the restassured  
		RestAssured.baseURI=prop.getProperty("baseuri");
		//Rest Assured is the request object.
		httprequest=RestAssured.given();
		//This line represents we can provide a payload data in json format
		httprequest.body(data);
		//print json data in console
		System.out.println(data);
		//Now we can create a response object and provide a request type to provide a path parameter with the request.
		//response= httprequest.request(Method.POST,ConstantReqestParameters.apiusers);
		//asString represents  whole response body converted into string format then we can able to see in console
		responsebody=response.getBody().asString();
		//Assert.assertEquals(response.getStatusCode(),this.isStatusPostRequestSucessCodeDisplayed());
		//Assert.assertEquals(response.getStatusLine(),this.isStatuslineDisplayed());
		
	}
	public void getParameterRequest2(String name) {
//		RestAssured.baseURI=prop.getProperty("baseuri");
//		//Rest Assured is the request object.
//		httprequest=RestAssured.given();
//		//Now we can create a response object and provide a request type to provide a path parameter with the request.
//		response= httprequest.request(Method.POST,name);
//		//asString represents  whole response body converted into string format then we can able to see in console
//		responsebody=response.getBody().asString();
//		System.out.println(responsebody);
//	}
}
}