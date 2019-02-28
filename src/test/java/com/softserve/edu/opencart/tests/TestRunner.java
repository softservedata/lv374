package com.softserve.edu.opencart.tests;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.shop.HomePage;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public abstract class TestRunner {
	protected final String SERVER_URL = "http://10.26.34.245/opencart/upload/";
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
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
		driver.get(SERVER_URL);
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if (!testResult.isSuccess()) {
			saveImageAttach(prepareImageName());
			driver.get(SERVER_URL);
		}
	}
	
	@Step("@Step: load HomePage")
	public HomePage loadApplication() {
		logger.debug("loadApplication() start");
		return new HomePage(driver); 
	}
	
	public String prepareImageName() {
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
				.format(new Date())
				+ "_screenshot.png";
	}
	
	@Attachment(value = "{0}", type = "image/png")
	public byte[] saveImageAttach(String attachName) {
		byte[] result = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			result = Files.readAllBytes(scrFile.toPath());
		} catch (IOException e) {
			// TODO Create Custom Exception 
			e.printStackTrace();
		}
		return result;
	}

}
