package com.dbyl.libarary.pageAction;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.dbyl.libarary.utils.BasePage;
import com.dbyl.libarary.utils.Locator;

public class replyLoanPageInfo extends BasePage {

	public replyLoanPageInfo(WebDriver driver) throws IOException {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}
	
	/*public replyLoanPageInfo(WebDriver driver) throws IOException {
		super(driver);
		driver.navigate().to("http://192.168.0.88/happyfi2.0/prd/purpose.html");
	}*/

	Locator loanMoney = new Locator("loanMoney");

	

	public void typeInputBox(String money) throws Exception {
		type(loanMoney, money);
	}

	public void sendKeysMethod(String exlpath,String value) throws Exception{
		Locator exlpath1 = new Locator(exlpath);
		type(exlpath1,value);
	}

	
	public void clickMethod(String clickPath) throws Exception{
		Locator exlpath1click = new Locator(clickPath);
		click(exlpath1click);		
	}
	
	
	public boolean checkCurrentPage(String element) throws Exception{
		Locator elementCurrent = new Locator(element);
		
			return isElementPresent(elementCurrent, 20);

	}
	
	
	public void waitForPageLoad() {
		super.getDriver().manage().timeouts()
				.pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	
}
