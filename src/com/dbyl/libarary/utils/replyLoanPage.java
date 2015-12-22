package com.dbyl.libarary.utils;


import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import com.dbyl.libarary.action.CommonLogin;

public class replyLoanPage extends Steps{

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
//	public replyLoanPage(WebDriver driver) throws Exception {
//		super(driver);
//		driver.get("http://192.168.0.88/happyfi2.0/prd/login.html");
//	}
	
/*	@Then("I should be taken to uCenter.html")
	public static void checkuCenter() throws Exception {
		 WebElement aboutLink = driver.findElement(By.linkText("马上联系我"));		
		 //Link lnkWelcome = new Link("welcome username link", "//span[@id='welcome-username']");
		 Assertion a = new Assertion();
		 a.assertTrue(aboutLink.isDisplayed(), "not current page");
		
	}*/



	public static void typeLoanInfo() throws Exception {

		CommonLogin.setDriver(driver);
		CommonLogin.typeLoan();
	}

	public static void setDriver(WebDriver driver) {
		replyLoanPage.driver = driver;
	}

}
