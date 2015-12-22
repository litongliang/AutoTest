package com.dbyl.libarary.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class replyLoan extends UITest{
	
	WebDriver driver=DriverFactory.getChromeDriver();
	@BeforeMethod(alwaysRun=true)
	public void init()
	{
		super.init(driver);
		replyLoanPage.setDriver(driver);
		//CommonLogin.setDriver(driver);
	}
	@Test(groups="replyLoan")
	public void replyLoanInfo() throws Exception
	{
		driver.get("http://192.168.0.88/happyfi2.0/prd/purpose.html");
		//CommonLogin.typeLoan();
		replyLoanPage.typeLoanInfo();
		
	}

	@AfterMethod(alwaysRun=true)
	public void stop() {

	//	super.stop();
	}

}
