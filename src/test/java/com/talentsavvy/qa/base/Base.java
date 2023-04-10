package com.talentsavvy.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import com.jayway.jsonpath.JsonPath;



public class Base {
	
	
	public Properties prop;
	public Properties dataprop;
	public Base() {
		
	    prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\talentsavvy\\config\\logindata.properties");
		
		try {
		
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	
	  public void json(String element) throws IOException {
		  File jsonfile= new File(prop.getProperty("jsonpath"));
		  Object data=JsonPath.read(jsonfile,"$."+element);
	  
	  }
	 

}
