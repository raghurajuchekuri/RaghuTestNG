package com.Tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TitanAPI {
	
	public static String access_token = null;
	
	
	
	@Test (priority=0, enabled=true, description = "1. OAUTH Salesforce login service URL and Parameters")
	public void getAccesscode()	{
		
		 RestAssured.baseURI ="https://test.salesforce.com/";
		 RequestSpecification request = RestAssured.given();	
		 
		 Response response = request.post("/services/oauth2/token?grant_type=password&client_id=3MVG9er.T8KbeePTR01z717K1cNgGgzJcSZX16ttn8YAj8EKC3TGGHDaaTnRMYnhJ28WaSDgMsVSV5NsCmEdX&client_secret=198F79F55CCD332C1663647258344D1E6645A532F6F0851265757FF396157E3F&username=suntech@billdco.com.titan&password=Stic@2020HPIwuvO0Q8ACST1efWDfegU1E");
		 
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, 200);
		 
		 access_token = response.jsonPath().get("access_token");
		 System.out.println(access_token);	
	}
	
	
	
	@Test (priority=1, enabled=false, description = "2. POST Customer Sign Up: Create Lead in SF")
	public void createLeadinSF()	{ 
		
		RestAssured.baseURI ="https://billdco123--titan.my.salesforce.com/";
		RequestSpecification request = RestAssured.given();
		 
		// Add a header stating the Request body is a JSON			 
		 request.header("Authorization", "Bearer "+ access_token);
		 request.header("Content-Type", "application/json");
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("RecordTypeId","012f4000000JhjmAAC"); 
		 requestParams.put("Company","Stic rr Lead");
		 requestParams.put("DBA__c","working as dba");
		 requestParams.put("Street","dsf Street");	 
		 requestParams.put("City","Hyderabad");
		 requestParams.put("PostalCode","89030");
		 requestParams.put("Phone","1234567890");
		 requestParams.put("FirstName","eff");
		 requestParams.put("LastName","ewrw");
		 requestParams.put("Email","dfsffs@gmail.com");
		 requestParams.put("Lead_Type__c","Licensed Contractor");	 
		 requestParams.put("LeadSource","Lien Seminar");
		 requestParams.put("Accepted_TitanLien_Service_Agreement__c",true); 		
		 
		 request.body(requestParams.toString());
		 Response response = request.post("/services/data/v47.0/sobjects/Lead");
		 
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, 201);
		 
		 boolean successStatus = response.jsonPath().get("success");
		 System.out.println(successStatus);
		 Assert.assertEquals( successStatus, true);
	}


}
