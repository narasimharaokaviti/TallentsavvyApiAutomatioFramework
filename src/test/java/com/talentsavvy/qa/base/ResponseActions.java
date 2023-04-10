package com.talentsavvy.qa.base;

    public class ResponseActions {
    	
	public String isStatusGetRequestSucessCodeDisplayed() {
		String statuscode = "200 Ok";
		System.out.println("StatusCode is Displayed successfully ");
		return  statuscode;
	}

	public String isStatusPostRequestSucessCodeDisplayed() {
		String statuscode = "201 CREATED";
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
