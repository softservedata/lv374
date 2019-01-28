package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	// @Test
	public void testApp() {
		Assert.assertTrue(true);
	}

	@Test
	public void testApp1() throws Exception {
		System.out.println("surefire.reports.directory = " + System.getProperty("surefire.reports.directory"));
		System.out.println("selenium.version = " + System.getProperty("selenium.version"));
		System.out.println("System.getenv().database.password = " + System.getenv().get("DATABASE_PASSWORD"));
	}

//	@DataProvider(parallel = true)
//	public Object[][] concurrencyData() {
//		return new Object[][] {
//			{ "1" },
//			{ "2" },
//		};
//	}

	@Test // (dataProvider = "concurrencyData")
	public void checkSeleniumIDE() throws Exception {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		System.out.println("this.getClass().getResource(\"/chromedriver-windows-32bit.exe\").getPath() = "
				+ this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
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
		String actual = driver
				.findElement(By.xpath("//h3[text()='Selenium Standalone Server']/following-sibling::p[1]")).getText();
		Assert.assertEquals(actual, expected, "My_Error");
		Thread.sleep(4000); // For Presentation Only
		//
		driver.quit();
	}

}
