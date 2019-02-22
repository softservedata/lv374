package com.softserve.edu.opencart.tests.klymovets;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.mailbox.pages.MailLoginPage;
import com.softserve.edu.opencart.pages.shop.HomePage;

public abstract class TestRunner {

	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://localhost/opencart/upload/");
	}

	@AfterMethod
	public void afterMethod() {
		driver.get("http://localhost/opencart/upload/index.php?route=account/logout");
	}

	public HomePage loadApplication() {
		return new HomePage(driver);
	}
	
	public MailLoginPage loadMail() {
		return new MailLoginPage(driver);
	}

}
