/**
 * 
 */
package com.dbyl.libarary.action;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;

import com.dbyl.libarary.pageAction.HomePage;

public class ViewHomePage extends Steps{

	private static WebDriver driver;
	private static HomePage homePage;

	public static WebDriver getDriver() {
		return driver;
	}
	@When("I navigate to happfi homepage")
	public static void navigateToLoginPage() throws Exception {

		CommonLogin.setDriver(driver);
		CommonLogin.loginToHomePage();
		
	}
	@Then("I type in name and password in login.html")
	public static void submitLoginPage() throws Exception {

		CommonLogin.setDriver(driver);
		CommonLogin.login();
	}
	
	@Then("I should be taken to uCenter.html")
	public static void checkuCenter() throws Exception {
		 WebElement aboutLink = driver.findElement(By.linkText("马上联系我"));		
		 //Link lnkWelcome = new Link("welcome username link", "//span[@id='welcome-username']");
		 Assertion a = new Assertion();
		 a.assertTrue(aboutLink.isDisplayed(), "not current page");
		
	}


	public static void viewMyProfile() throws Exception {

		CommonLogin.setDriver(driver);
		homePage = CommonLogin.login();
		homePage.clickOnMyProfile();
	}

	public static void setDriver(WebDriver driver) {
		ViewHomePage.driver = driver;
	}

}
