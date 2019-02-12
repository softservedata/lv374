package com.softserve.edu.opencart.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.shop.HomePage;

public abstract class TestRunner {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://192.168.103.181/opencart/upload/");
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if (!testResult.isSuccess()) {
			driver.get("http://192.168.103.181/opencart/upload/");
		}
	}
	
	public HomePage loadApplication() {
		return new HomePage(driver); 
	}
}