package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.pages.shop.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class TestRunnerVoluikevych {
	protected final String SERVER_URL = "http://localhost/opencart/upload/";

	protected WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} else {
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

	public HomePage loadApplication() {
		return new HomePage(driver);
	}

}
