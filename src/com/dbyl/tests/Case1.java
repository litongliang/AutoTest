package com.dbyl.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Case1 {
	

	public static int add(int a, int b)
	{
		return a+b;
	}
	public static void test1() {
		Assert.assertEquals(true, true);
	}

	public static void test2() {
		Assert.assertEquals(add(5,4), 9);
	}

	@BeforeClass
	public void setUp() {
		
	}

	@Test(groups = { "Case1" })
	public void aFastTest() {
		test1();
		System.out.println("Fast test");
	}

	@Test(groups = { "Case1" })
	public void aSlowTest() {
		test2();
		System.out.println("Slow test");
	}

}
