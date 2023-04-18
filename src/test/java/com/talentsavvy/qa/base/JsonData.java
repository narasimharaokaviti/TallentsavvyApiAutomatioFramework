package com.talentsavvy.qa.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;

import com.jayway.jsonpath.JsonPath;

public class JsonData  {

	JSONParser jsonp;
	FileReader reader;
	static File jsonfile;
	static Object data;
	
	public static  void jsonResource(String element) throws IOException { 
		jsonfile= new File("C:\\Users\\naras\\eclipse-workspace\\Com.Talentsavvy\\src\\main\\java\\com\\talentsavvy\\config\\data.json");
		data=JsonPath.read(jsonfile,"$."+element);
		
	}
}
