package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

	@Test
	public void checkSeleniumIDE() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		driver.get("https://www.google.com");
		// driver.navigate().to("https://www.google.com");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("selenium automation" + Keys.ENTER);
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.xpath("//h3[text()='Selenium - Web Browser Automation']/..")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.linkText("Download")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		String expected = "The Selenium Server is needed in order to run Remote Selenium WebDriver. Selenium 3.X is no longer capable of running Selenium RC directly, rather it does it through emulation and the WebDriverBackedSelenium interface.";
		String actual = driver.findElement(By.xpath("//h3[text()='Selenium Standalone Server']/following-sibling::p[1]")).getText();
		Assert.assertEquals(actual, expected, "My_Error dev branch");
		Thread.sleep(4000); // For Presentation Only
		//
		driver.quit();
	}

}
