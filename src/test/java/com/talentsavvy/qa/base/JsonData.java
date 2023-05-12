package com.talentsavvy.qa.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

public class JsonData  {

	JSONParser jsonp;
	FileReader reader;
	File jsonfile;
	Object data;
	
	public   void jsonResource(String element) throws IOException { 
		File jsonfile= new File("C:\\Users\\naras\\eclipse-workspace\\Com.Talentsavvy\\src\\main\\java\\com\\talentsavvy\\config\\data.json");
		Object data=JsonPath.read(jsonfile,"$."+element);
		
	}
	@Test
	public void login(String element) throws IOException {
		jsonResource("employee1.name");
		jsonResource("employee1.job");
		System.out.println(data);
		
	}
}
