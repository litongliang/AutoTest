package com.dbyl.libarary.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class TestHapfi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//设置浏览器driver
		WebDriver driver;
		driver=new FirefoxDriver();
		try {
			driver.get("http://localhost:8080/sq/happyfi2.0/prd/purpose.html");

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace(); 
        }
		//purpose.html
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[2]/div[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[2]/div[2]/input")).sendKeys("50000");
		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/a")).click();
		/*try {
			driver.wait(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		 * 
*/		
		driver.navigate().to("http://localhost:8080/sq/happyfi2.0/prd/personInfo.html");
		
		//driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/a")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[1]/input")).sendKeys("测试一");
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[2]/input")).sendKeys("370809888422221212");
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[3]/input")).sendKeys("15077687981");
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[2]/input")).click();		
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[4]/input[2]")).click();
		
		
		/*//处理 alert
		 Alert alert = driver.switchTo().alert();
		 if(null ==alert){		
			 
			 throw new NoAlertPresentException();
			
		 }else{
			 
			 alert.accept();
		 }*/
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[4]/input[1]")).sendKeys("123456");
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[5]/select/option[5]")).click();
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[6]/select/option[4]")).click();
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[7]/select/option[2]")).click();
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[8]/select/option[6]")).click();
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[9]/select/option[6]")).click();
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[10]/select/option[8]")).click();
		 driver.findElement(By.xpath("/html/body/di'v[3]/div[1]/div/div[1]/div[2]/ul/li[11]/input")).sendKeys("18209900001");
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/ul/li[12]/select/option[5]")).click();
		 driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div[2]/input")).click();
		 Alert alertsub = driver.switchTo().alert();
		 
		 alertsub.accept();
		
		 
		//关闭浏览器
		//driver.close();
		
		
	}

}
