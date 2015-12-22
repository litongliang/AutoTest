package com.dbyl.libarary.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Cookie;

import com.dbyl.libarary.utils.DriverFactory;

public class Cookies {
	
	public static void addCookies() {

		
		WebDriver driver = DriverFactory.getChromeDriver();
		driver.get("http://192.168.0.88/happyfi2.0/prd/login.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement user = driver
				.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/input"));
		user.clear();
		user.sendKeys("13818797911");
		WebElement password = driver.findElement(By
				.xpath("/html/body/div[3]/div/div[2]/div[2]/div[2]/div[2]/input"));
		password.clear();
		password.sendKeys("welcome1");

		WebElement submit = driver.findElement(By
				.xpath("/html/body/div[3]/div/div[2]/button"));
		submit.submit();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File file = new File("broswer.data");
		try {
			// delete file if exists
			file.delete();
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Cookie ck : driver.manage().getCookies()) {
				bw.write(ck.getName() + ";" + ck.getValue() + ";"
						+ ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure());
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("cookie write to file");
		}
	}
}