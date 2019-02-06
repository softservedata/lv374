package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {

	@Test
	public void checkMac() throws Exception {
		// Precondition
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://192.168.103.181/opencart/upload/");
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("mac");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector(".btn.btn-default.btn-lg")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		String actual = driver.findElement(By.xpath("//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iMac')]/../following-sibling::p[@class='price']")).getText();
		Thread.sleep(1000); // For Presentation Only
		//
		// Check
		Assert.assertTrue(actual.contains("122.00"));
		Thread.sleep(1000); // For Presentation Only
		//
		// Return to Previous State
		driver.findElement(By.cssSelector("#logo img")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		driver.quit();
	}
	
}
