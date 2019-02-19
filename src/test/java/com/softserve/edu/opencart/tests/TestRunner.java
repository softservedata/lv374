package com.softserve.edu.opencart.tests;

import java.net.URL;
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
		URL url = this.getClass().getResource("/chromedriver-windows-32bit.exe");
		if (url == null) {
			// TODO Log
			//System.exit(1);
			// TODO Develop Custom Exception
			throw new RuntimeException("ERROR: Chromedriver not Found");
		}
		System.setProperty("webdriver.chrome.driver",
				url.getPath());
				//this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
		driver = new ChromeDriver();
		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} else {
			// TODO Log
			// System.exit(1);
			// TODO Develop Custom Exception
			throw new RuntimeException("ERROR: Chromedriver not Found");
		}
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://192.168.103.240/opencart/upload/");
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if (!testResult.isSuccess()) {
			driver.get("http://192.168.103.240/opencart/upload/");
		}
	}
	
	public HomePage loadApplication() {
		return new HomePage(driver); 
	}
}
