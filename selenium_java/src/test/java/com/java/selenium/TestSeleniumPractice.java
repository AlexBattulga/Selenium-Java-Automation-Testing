package com.java.selenium;

import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TestSeleniumPractice 
{
//	WebDriverConfig dr = new WebDriverConfig();
//	WebDriver chrome = dr.getChrome();
//	WebDriver firefox = dr.getFirefox();

	String name;
	String LargestCity;
	int start = 1;
	boolean play = true;
	@Test
	public void getAPITest()
	{
		while(play == true)
		{
			Scanner sc = new Scanner(System.in);
			String URL = "http://services.groupkt.com/state/get/USA/";
			System.out.println("Enter state name or abbreviation(VA, MO etc)");
			String input = sc.nextLine().toUpperCase();
			RestAssured.baseURI = URL + input;
			RequestSpecification httpRequest = RestAssured.given();
			Response resp = httpRequest.request(Method.GET);
			String respBody = resp.getBody().asString();
			// diving into JSONobject
			JSONObject jsonObj = new JSONObject(respBody);
			JSONObject restResponse = jsonObj.getJSONObject("RestResponse");
			JSONObject result = restResponse.getJSONObject("result");
			System.out.println(result);
			start++;
		}
	}
	//@Test
	public void keepRunningTest()
	{
		do
		{
			System.out.println("Test");
			start++;
		}while(play == false);
	}
}
