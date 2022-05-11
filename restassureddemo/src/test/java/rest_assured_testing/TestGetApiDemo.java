package rest_assured_testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;

public class TestGetApiDemo {
	
	
	
	@Test
	//check For list all the users without specifying page
	void test0()
	{
		
	Response resp=	get("https://reqres.in/api/users");
	System.out.println(resp.getBody().asString());
	System.out.println(resp.getHeader("content-type"));
	System.out.println(resp.getStatusCode());
	int status=resp.getStatusCode();
	Assert.assertEquals(status,200);
	
	}
	
	 
	@Test
	//check For list all the users
	void test1()
	{
		
	Response resp=	get("https://reqres.in/api/users?page=2");
	System.out.println(resp.getBody().asString());
	System.out.println(resp.getHeader("content-type"));
	System.out.println(resp.getStatusCode());
	int status=resp.getStatusCode();
	Assert.assertEquals(status,200);
	
	}
	
	@Test
	//check for single user
	void test2()
	
	{
		given().get("https://reqres.in/api/users/2").then().statusCode(200);
	}
	
	@Test
	//check for single user
	void test3()
	{
		baseURI="https://reqres.in/api/users?page=2";
		
		      RequestSpecification given = given();
		      
		      Response response= given.request(Method.GET,"/2");
		      System.out.println(response.getBody().asString());	
		      
		      int statusCode = response.getStatusCode();
		      
		      Assert.assertEquals(statusCode,200);
		      
		      
	}
	
	@Test
	//check for user not found
	void test4()
	{
		
		
		  baseURI="https://reqres.in/api/users?page=2";
	      RequestSpecification given = given();    
	      Response response= given.request(Method.GET,"/23");
	      System.out.println(response.getBody().asString());	  
	      int statusCode = response.getStatusCode();   
	      Assert.assertEquals(statusCode,404);
		
		
	}
	
	
	@Test
	//check for list all the resources
	void test5()
	{
		
		
		  baseURI="https://reqres.in/api/unknown";
	      RequestSpecification given = given();    
	      Response response= given.request(Method.GET);
	      System.out.println(response.getBody().asString());	  
	      int statusCode = response.getStatusCode();   
	      Assert.assertEquals(statusCode,200);
		
		
	}
	
	
	
	@Test
	//check for list all the resources
	void test6()
	{
		
		
		  baseURI="https://reqres.in/api/unknown";
	      RequestSpecification given = given();    
	      Response response= given.request(Method.GET,"/2");
	      System.out.println(response.getBody().asString());	  
	      int statusCode = response.getStatusCode();   
	      Assert.assertEquals(statusCode,200);
		
		
	}
	
	
	
	@Test
	//check for resouce  not found
	void test7()
	{
		
		
		  baseURI="https://reqres.in/api/unknown";
	      RequestSpecification given = given();    
	      Response response= given.request(Method.GET,"/23");
	      System.out.println(response.getBody().asString());	  
	      int statusCode = response.getStatusCode();   
	      Assert.assertEquals(statusCode,404);
		
		
	}
	
	

}
