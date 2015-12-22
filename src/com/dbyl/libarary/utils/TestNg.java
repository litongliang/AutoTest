package com.dbyl.libarary.utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg {
//@BeforeTest->@BeforeClass->(@BeforeMethod->@Test->@AfterTest)->...重复()内内容...->@AfterClass->@After
	
	@BeforeTest
	public void setUp(){
	System.out.println("*******before********");
	}
	@BeforeMethod
	public void beforeMethod(){
	System.out.println("*******beforeMethod********");
	}
	@AfterMethod
	public void afterMethod(){
	System.out.println("*******aftermethod********");
	}
	@Test
	public void t1(){
	System.out.println("*********t1**********");
	}
	@Test
	public void t2(){
	System.out.println("*********t2**********");
	}
	@BeforeClass
	public static void  beforeClass(){
	System.out.println("*****beforeClass*****");
	}
	@AfterClass
	public  static void afterClass(){
	System.out.println("*****afterClass*****");
	}
	@AfterTest
	public void finish(){
	System.out.println("*******finish********");
	}
}