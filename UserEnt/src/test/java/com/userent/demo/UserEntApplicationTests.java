package com.userent.demo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntApplicationTests {

	@BeforeClass
	public static void setUp()
	{
		String port=System.getProperty("server.port");
		
		if(port==null)
				RestAssured.port=Integer.valueOf(8080);
		else
			RestAssured.port=Integer.valueOf(port);
		
		
		String context_path=System.getProperty("server.base");
		if(context_path==null)
			context_path="/boot/hibernate";
		RestAssured.basePath=context_path;
	}
	
	
	@Test
	public void contextLoads() {
	}

}
