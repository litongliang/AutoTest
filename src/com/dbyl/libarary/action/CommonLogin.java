package com.dbyl.libarary.action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.dbyl.libarary.pageAction.HomePage;
import com.dbyl.libarary.pageAction.LoginPage;
import com.dbyl.libarary.pageAction.replyLoanPageInfo;
import com.dbyl.libarary.utils.replyLoanPage;
import com.thoughtworks.selenium.Wait;

public class CommonLogin  extends Thread{

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	static LoginPage loginPage;
	static replyLoanPageInfo loanPageInfo;
	public static HomePage login(String name, String password)
			throws Exception {
		loginPage = new LoginPage(getDriver());
		loginPage.waitForPageLoad();
		loginPage.typeInputBox(name);
		loginPage.typePasswordInputBox(password);
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.isPrestentProfile(), "login failed");
		return new HomePage(getDriver());
	}
	
	
	public static void typeLoan()   throws Exception {
		// TODO Auto-generated method stub
		
		loanPageInfo =new replyLoanPageInfo(getDriver());
		loanPageInfo.waitForPageLoad();
		//loanPageInfo.typeInputBox("50000");
		loanPageInfo.sendKeysMethod("loanMoney", "50000");
		loanPageInfo.clickMethod("watchTotalNum");
		//loanPageInfo.checkCurrentPage("checkpreliminary");
		Assert.assertTrue(loanPageInfo.checkCurrentPage("checkpreliminary"), "This is not preliminary.html !");
		driver.navigate().to("http://192.168.0.88/happyfi2.0/prd/personInfo.html");
		
		loanPageInfo.sendKeysMethod("username", "王铭");
		loanPageInfo.sendKeysMethod("userID","370802199405134518");
		loanPageInfo.sendKeysMethod("userPhoneNum","15122781833");
		loanPageInfo.clickMethod("userID");
		loanPageInfo.clickMethod("sendNum");
		//Wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(3000);
		try{
			 Alert alert = driver.switchTo().alert();
			 if(null ==alert){						 
				 throw new NoAlertPresentException();				
			 }else{				 
				 alert.accept();
			 }			
		}catch(NoAlertPresentException a){

			System.out.print("No alert");
		}
		
		loanPageInfo.sendKeysMethod("typeNum", "123456");
		loanPageInfo.clickMethod("jobClick");
		loanPageInfo.clickMethod("houseClick");
		loanPageInfo.clickMethod("marryClick");
		loanPageInfo.clickMethod("colleageClick");
		loanPageInfo.clickMethod("salaryClick");
		loanPageInfo.clickMethod("othersClick");
		loanPageInfo.sendKeysMethod("OtherContact", "18201778888");
		loanPageInfo.clickMethod("relationShip");
		loanPageInfo.clickMethod("confirmLoanInfo");
		loanPageInfo.clickMethod("swichOne");		
		 try{
			 Alert alert = driver.switchTo().alert();
			 if(null ==alert){		
				 
				 throw new NoAlertPresentException();
				
			 }else if(alert.getText()=="手机验证信息为空或错误"){
				 alert.accept();
				// driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[4]/input[2]")).click();
				 loanPageInfo.clickMethod("sendNum");
				// driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/input")).click();
				 loanPageInfo.clickMethod("confirmLoanInfo");
				// driver.findElement(By.xpath("//*[@id='basePup']/div/div[2]/div[3]/button[2]")).click(); 
				 loanPageInfo.clickMethod("swichOne");
				 }
							
			
		}catch(NoAlertPresentException a){
			Alert alert = driver.switchTo().alert();
			 alert.accept();
			 loanPageInfo.clickMethod("sendNum"); 
			 loanPageInfo.clickMethod("confirmLoanInfo");
			 loanPageInfo.clickMethod("swichOne");
			System.out.print("No alert");
		}
	}
	
	public static void  loginToHomePage()
			throws Exception {
		loginPage = new LoginPage(getDriver());
		loginPage.waitForPageLoad();
	}
	public static HomePage login() throws Exception {
		return CommonLogin.login("13818797911", "welcome1");
	}
	


	public static void setDriver(WebDriver driver) {
		CommonLogin.driver = driver;
	}




}
