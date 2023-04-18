package com.talentsavvy.qa.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.talentsavvy.config.ConstantReqestParameters;
import com.talentsavvy.qa.base.Base;
import com.talentsavvy.qa.base.JsonData;
import com.talentsavvy.qa.base.ResponseActions;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners({com.talentsavvy.qa.test.Itestlistners.class})
public class ApiTestCases extends Base  {
	RequestSpecification httprequest;
	Response response;
	String responsebody;
	int responsecode;
	String statusline;
	JSONParser jsonp;
	FileReader reader;
	File jsonfile;
	Object data;
	io.restassured.path.json.JsonPath path;

	@Test(priority=0,description="This testcase verifies creata a user",enabled=true) 
	public void verifyCreateUserApiTest() throws IOException {
		RequestMethods.jsonResource("employee1");
		RequestMethods.PostparameterRequest(ConstantReqestParameters.apiusers);
		System.out.println("Responce code is"+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),ResponseActions.isStatusPostRequestSucessCodeDisplayed(),"status code sucess");
		path=response.jsonPath();
		System.out.println(path.get("id"));
	}
	@Test(priority=1,description="This testcase verifies creata a user",enabled=true) 
	public void verifyGetUserAPiTest() {
		RequestMethods.getParameterRequest(ConstantReqestParameters.getapiusers); 
		System.out.println(response);
	}

	@Test(priority=2,description="This testcase verifies creata a user",enabled=true)
	public void verifyUpdateUserApiTest() throws IOException {
		RequestMethods.jsonResource("employee2");
		RequestMethods.PostparameterRequest(ConstantReqestParameters.putapiuser2);
		}

	@Test(priority=3,description="This testcase verifies creata a user",enabled=true) 
	public void verifyDeleteUserApiTest() throws IOException {
	RequestMethods.PostparameterRequest(ConstantReqestParameters.putapiuser2); 
	}



	@Test
	public  void PostparameterRequest() throws IOException {
		jsonResource("employee1");
		RestAssured.baseURI=prop.getProperty("baseuri");
		//Rest Assured is the request object.
		httprequest=RestAssured.given();
		//This line represents we can provide a payload data in json format
		httprequest.body(data);
		//print json data in console
		//System.out.println(data);
		//Now we can create a response object and provide a request type to provide a path parameter with the request.
		response= httprequest.request(Method.POST,ConstantReqestParameters.apiusers);
		//asString represents  whole response body converted into string format then we can able to see in console
		responsebody=response.getBody().asString();
		System.out.println("Responce body is"+responsebody);
		path=response.jsonPath();
		Assert.assertEquals(response.getStatusCode(),ResponseActions.isStatusPostRequestSucessCodeDisplayed(),"status code sucess");
		System.out.println(response.getStatusCode());
		System.out.println(path.get("id"));
	}
	public void jsonResource(String element) throws IOException { 
		jsonfile= new File(prop.getProperty("jsonpath"));
		data=JsonPath.read(jsonfile,"$."+element);

	}}
