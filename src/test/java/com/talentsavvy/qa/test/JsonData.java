package com.talentsavvy.qa.test;

import java.io.File;
import java.io.FileReader;

import org.json.simple.parser.JSONParser;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonData {
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

}
