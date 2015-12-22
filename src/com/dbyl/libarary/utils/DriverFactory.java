package com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;




public class DriverFactory {

	private static String chromedriver;
	private static String fireBug;
	private static Properties p = null;
	private static String IEDriverServer;
	private static String config = "D:\\projects\\Demo\\config.properties";

	public static WebDriver getHtmlUnit() {
		HtmlUnitDriver ht = new HtmlUnitDriver();
		return ht;
	}

	public static WebDriver getChromeDriver() {

		try {
			p = getProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (p != null) {
			chromedriver = p.getProperty("chromedriver");
		}
		System.out.print(chromedriver);
		System.setProperty("webdriver.chrome.driver", chromedriver);
		
		ChromeOptions options = new ChromeOptions();
		// options.addExtensions(new File(""));
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches",
				Arrays.asList("--start-maximized"));
		options.addArguments("--test-type", "--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	public static Properties getProperties() throws IOException {
		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream(new File(config));
		properties.load(inStream);
		return properties;
	}

	public static WebDriver getFirefoxDriver() {
		try {
			WindowsUtils.tryToKillByName("firefox.exe");
		} catch (Exception e) {
			System.out.println("can not find firefox process");
		}
		if (p != null) {
			fireBug = p.getProperty("fireBug");
		}
		File file = new File(fireBug);
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(file);
			profile.setPreference("extensions.firebug.currentVersion", "2.0.4");
			profile.setPreference("extensions.firebug.allPagesActivation",
					"off");
		} catch (IOException e3) {
			e3.printStackTrace();
		}

		WebDriver driver = new FirefoxDriver(profile);
		return driver;

	}

	public static WebDriver getIEDriver() {
		if (p != null) {
			IEDriverServer = p.getProperty("IEDriverServer");
		}
		System.setProperty("webdriver.ie.driver", IEDriverServer);
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}

}
