package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuTest {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("http://regres.herokuapp.com/login");
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if (!testResult.isSuccess()) {
			driver.get("http://regres.herokuapp.com/logout");
		}
	}

	//@Test
	public void checkCSS() throws Exception {
		//
		Thread.sleep(1000); // For Presentation Only
		//
//		WebElement login = driver.findElement(By.cssSelector("#login"));
//		login.click();
//		login.clear();
//		login.sendKeys("hahaha");
//		Thread.sleep(1000); // For Presentation Only
		//
		// code...
//		driver.navigate().refresh();
		//
//		login.click();
//		login.clear();
//		login.sendKeys("work");
		//
//		driver.findElement(By.cssSelector("#login")).click();
//		driver.findElement(By.cssSelector("#login")).clear();
//		driver.findElement(By.cssSelector("#login")).sendKeys("hahaha");
//		Thread.sleep(1000); // For Presentation Only
		//
//		driver.navigate().refresh();
		//
		driver.findElement(By.cssSelector("#login")).click();
		driver.findElement(By.cssSelector("#login")).clear();
		driver.findElement(By.cssSelector("#login")).sendKeys("work");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector("#password")).click();
		driver.findElement(By.cssSelector("#password")).clear();
		driver.findElement(By.cssSelector("#password")).sendKeys("qwerty");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm:not(.dropdown-toggle)")).getText(),
				"work", "My_Error");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm:not(.dropdown-toggle)")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector("a[href*='logout']")).click();
		//
		Assert.assertTrue(driver.findElement(By.cssSelector("img")).getAttribute("src").contains("ukraine_logo2.gif"),
				"My_Error2");
		Thread.sleep(1000); // For Presentation Only
	}

	@Test
	public void checkXPath() throws Exception {
		//
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.xpath("//input[@id='login']")).click();
		driver.findElement(By.xpath("//input[@id='login']")).clear();
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys("work");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("qwerty");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")).getText(),
				"work", "My_Error");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'dropdown-toggle')]")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		//
		Assert.assertTrue(driver.findElement(By.xpath("//img")).getAttribute("src").contains("ukraine_logo2.gif"),
				"My_Error2");
		Thread.sleep(1000); // For Presentation Only
	}

}
