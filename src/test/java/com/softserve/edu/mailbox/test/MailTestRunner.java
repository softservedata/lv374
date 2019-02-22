package com.softserve.edu.mailbox.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.mailbox.pages.MailLoginPage;

public class MailTestRunner {

	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://accounts.ukr.net/login");
	}

	@AfterMethod
	public void afterMethod() {
		driver.get("https://mail.ukr.net/q/logout");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	public MailLoginPage loadMailApplication() {
		return new MailLoginPage(driver);
	}

}
