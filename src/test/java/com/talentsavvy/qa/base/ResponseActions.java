package com.talentsavvy.qa.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.talentsavvy.qa.test.RequestMethods;



public class ResponseActions {
	static Logger loger = LogManager.getLogger(RequestMethods.class);
    	public static final String value="";
    	
	public static int isGetRequestSucessCodeDisplayed() {
		int statuscode = 200;
      
		return  statuscode;
	}

	

	public static int isStatusPostRequestSucessCodeDisplayed() {
		int statuscode = 201 ;
		//System.out.println();
		loger.info("StatusCode is Displayed successfully ");	
		loger.debug("StatusCode is Displayed successfully ");
		loger.error("StatusCode is Displayed successfully ");
		return  statuscode;
	}

	public static int isPutRequestSucessCodeDisplayed() {
		int statuscode = 200 ;
		System.out.println("StatusCode is Displayed successfully ");
		return  statuscode;
	}
 
	public String isStatuslineDisplayed() {
		String statusline = "HTTP/1.1 200 ";
		System.out.println("Statusline is Displayed successfully ");
		return  statusline;
	}

	public String isExpectedSucessStatusDisplayed() {
		String SucessStatus = "SUCCESS";
		return  SucessStatus;
	}

	public String isExpectedErrorStatusDisplayed() {
		String SucessStatus = "ERROR";
		return  SucessStatus;
	}

	public Object isExpectedApiDeleted() {
		String response =null;
		System.out.println(" API  is Deleted successfully ");
		return  response;

	}
}
