package com.dbyl.libarary.pageAction;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.Given;
import org.openqa.selenium.WebDriver;

import com.dbyl.libarary.utils.BasePage;
import com.dbyl.libarary.utils.Locator;

public class LoginPage extends BasePage {

	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}
	
	public LoginPage(WebDriver driver) throws IOException {
		super(driver);
		driver.get("http://192.168.0.88/happyfi2.0/prd/login.html");
	}

	Locator loginInputBox = new Locator("loginHapPhone");

	Locator loginPasswordInputBox = new Locator("loginHapPassword");
	Locator loginButton = new Locator("loginButtonHap");
	Locator profile = new Locator(
			"profile");

	public void typeInputBox(String name) throws Exception {
		type(loginInputBox, name);
	}

	public void typePasswordInputBox(String password) throws Exception {
		type(loginPasswordInputBox, password);
	}

	public void clickOnLoginButton() throws Exception {
		click(loginButton);
	}

	public boolean isPrestentProfile() throws IOException {
		return isElementPresent(profile, 20);

	}

	public void waitForPageLoad() {
		super.getDriver().manage().timeouts()
				.pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	
}
