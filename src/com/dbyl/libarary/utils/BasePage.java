package com.dbyl.libarary.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected String[][] locatorMap;

	protected BasePage(WebDriver driver) throws IOException {
		this.driver = driver;
		locatorMap = ReadExcelUtil.getLocatorMap();
	}

	protected void type(Locator locator, String values) throws Exception {
		WebElement e = findElement(driver, locator);
		e.sendKeys(values);
	}
	
	/** 
	 * 
	 * @Description: 通过使用 ImageIO 类来保存 Image 对象为本地图片
	 * @param image ： 需要保存的 Image 对象
	 * @param filename ： 文件名
	 */ 
	 public static void saveImage(Image image, String fileName) throws Exception { 
		 // 获取 Image 对象的高度和宽度
		 int width = image.getWidth(null); 
		 int height = image.getHeight(null); 
		 BufferedImage bi = new BufferedImage(width, height, 
				 BufferedImage.TYPE_INT_RGB); 
		 Graphics g = bi.getGraphics(); 
	     //通过 BufferedImage 绘制图像并保存在其对象中
		 g.drawImage(image, 0, 0, width, height, null); 
		 g.dispose(); 
		 File f = new File(fileName); 
		 // 通过 ImageIO 将图像写入到文件
		 ImageIO.write(bi, "jpg", f); 
		 }
	
	protected void draganddrop(WebElement source,WebElement target,int xOffset,int yOffset){
		
		Actions action = new Actions(driver); 
		// 鼠标拖拽动作，将 source 元素拖放到 target 元素的位置。
		 action.dragAndDrop(source, target);
		// 鼠标拖拽动作，将 source 元素拖放到 (xOffset, yOffset) 位置，其中 xOffset 为横坐标，yOffset 为纵坐标。
		action.dragAndDropBy(source, xOffset, yOffset);
		
	}

	protected void click(Locator locator) throws Exception {
		WebElement e = findElement(driver, locator);
		e.click();
	}
	//这模拟用户的鼠标mouse，。对于这些操作，使用perform()方法进行执行
	protected void clickAndHold(Locator locator) throws IOException {
		WebElement e = findElement(driver, locator);
		Actions actions = new Actions(driver);
		actions.clickAndHold(e).perform();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(Locator locator) throws IOException {
		return getElement(this.getDriver(), locator);
	}

	public WebElement getElement(WebDriver driver, Locator locator)
			throws IOException {
		locator = getLocator(locator.getElement());
		WebElement e;
		switch (locator.getBy()) {
		//selenium总共有八种定位方法 
		// By.id()  通过id定位
		// By.name()  通过name 定位
		// By.xpath() 通过xpath定位
		// By.className() 通过className定位
		// By.cssSelector() 通过CSS 定位
		// By.linkText() 通过linkText
		// By.tagName() 通过tagName
		// By.partialLinkText() 通过匹到的部分linkText
		case xpath:
			e = driver.findElement(By.xpath(locator.getElement()));
			break;
		case id:
			e = driver.findElement(By.id(locator.getElement()));
			break;
		case name:
			e = driver.findElement(By.name(locator.getElement()));
			break;
		case cssSelector:
			e = driver.findElement(By.cssSelector(locator.getElement()));
			break;
		case className:
			e = driver.findElement(By.className(locator.getElement()));
			break;
		case tagName:
			e = driver.findElement(By.tagName(locator.getElement()));
			break;
		case linkText:
			e = driver.findElement(By.linkText(locator.getElement()));
			break;
		case partialLinkText:
			e = driver.findElement(By.partialLinkText(locator.getElement()));
			break;
		default:
			e = driver.findElement(By.id(locator.getElement()));
		}
		return e;
	}

	public boolean isElementPresent(WebDriver driver, Locator myLocator,
			int timeOut) throws IOException {
		final Locator locator = getLocator(myLocator.getElement());
		boolean isPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		isPresent = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return findElement(d, locator);
			}
		}).isDisplayed();
		return isPresent;
	}
	
	

	/**
	 * This Method for check isPresent Locator
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 * @throws IOException
	 */
	public boolean isElementPresent(Locator locator, int timeOut)
			throws IOException {
		return isElementPresent(driver,locator, timeOut);
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement findElement(WebDriver driver, final Locator locator) {
		WebElement element = (new WebDriverWait(driver, locator.getWaitSec()))
				.until(new ExpectedCondition<WebElement>() {

					@Override
					public WebElement apply(WebDriver driver) {
						try {
							return getElement(driver, locator);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							return null;
						}

					}

				});
		return element;

	}

	public Locator getLocator(String locatorName) throws IOException {

		Locator locator;
		for (int i = 0; i < locatorMap.length; i++) {
			if (locatorMap[i][0].endsWith(locatorName)) {
				return locator = new Locator(locatorMap[i][1]);
			}
		}

		return locator = new Locator(locatorName);

	}
}
