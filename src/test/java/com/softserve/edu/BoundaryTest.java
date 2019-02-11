package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BoundaryTest {
	public WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://taqc-opencart.epizy.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeTest
	public void cartEntry() {
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
	}

	@Test(priority = 1)
	public void positiveTestOne() throws Exception {
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).click();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).clear();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]"))
				.sendKeys("1" + Keys.ENTER);
		Thread.sleep(2000);
		String actMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success' and contains(text(), 'Success')]")).getText();
		String expMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-danger' and contains(text(), 'No changes')]"))
				.getText();
		Assert.assertEquals(actMessage, expMessage, "My_Error");
	}

	@Test(priority = 2)
	public void positiveTest() throws Exception {
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).click();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).clear();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]"))
				.sendKeys("967" + Keys.ENTER);
		Thread.sleep(2000);
		String actMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success' and contains(text(), 'Success')]")).getText();
		boolean actual = actMessage.contains("Success");
		Assert.assertEquals(true, actual, "My_Error");
	}

	@Test(priority = 3)
	public void negativeTestMax() throws Exception {
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).click();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).clear();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]"))
				.sendKeys("968" + Keys.ENTER);
		Thread.sleep(2000);
		String expMessage = "Products marked with *** are not available in the desired quantity or not in stock!";
		boolean expected = expMessage.contains("not available");
		String actMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-danger' and contains(text(), 'not available')]"))
				.getText();
		boolean actual = actMessage.contains("not available");
		Assert.assertEquals(actual, expected, "My_Error");
	}

	@Test(priority = 4)
	public void negativeTestZero() throws Exception {
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).click();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]")).clear();
		driver.findElement(By.xpath("//input[@type='text' and starts-with(@name, 'quantity')]"))
				.sendKeys("0" + Keys.ENTER);
		Thread.sleep(2000);
		String expected = "Your shopping cart is empty!";
		String actual = driver.findElement(By.xpath("//div[@id='content']/p")).getText();
		Assert.assertEquals(actual, expected, "My_Error");
	}

	@AfterSuite
	public void turnOff() {
		driver.quit();
	}

}