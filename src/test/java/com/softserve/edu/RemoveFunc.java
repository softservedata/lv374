package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RemoveFunc {
	public WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://taqc-opencart.epizy.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void removeItem() throws Exception {
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-original-title='Remove']")).click();
		Thread.sleep(2000);
		String expected = "Your shopping cart is empty!";
		String actual = driver.findElement(By.xpath("//div[@id='content']/p")).getText();
		Assert.assertEquals(actual, expected, "My_Error");
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
	}

	@Test(priority = 2)
	public void removeItemBlockButton() throws Exception {
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@id='cart-total']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@title='Remove']")).click();
		String expected = "0 item(s) - $0.00";
		String actual = driver.findElement(By.xpath("//span[@id='cart-total']")).getText();
		Assert.assertEquals(expected, actual, "My_Error");
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
	}
	

	@Test(priority = 3)
	public void removeItems() throws Exception {
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('43');\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Shopping Cart']")).click();
		driver.findElement(By.xpath("//*[@data-original-title='Remove']")).click();
		Thread.sleep(2000);
		String firstActual = driver.findElement(By.xpath("//span[@id='cart-total']")).getText();
		String firstExpected = "1 item(s) - $602.00";
		Assert.assertEquals(firstActual, firstExpected, "My_Error");
		driver.findElement(By.xpath("//*[@data-original-title='Remove']")).click();
		Thread.sleep(2000);
		String secondActual = driver.findElement(By.xpath("//span[@id='cart-total']")).getText();
		String secondExpected = "0 item(s) - $0.00";
		Assert.assertEquals(secondActual, secondExpected, "My_Error");
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
	}

	@Test(priority = 4)
	public void removeItemsBlockButton() throws Exception {
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('40');\"]")).click();
		driver.findElement(By.xpath("//button[@onclick=\"cart.add('43');\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[@id='cart-total']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@title='Remove']")).click();
		Thread.sleep(4000);
		String firstActual = driver.findElement(By.xpath("//span[@id='cart-total']")).getText();
		String firstExpected = "1 item(s) - $602.00";
		Assert.assertEquals(firstActual, firstExpected, "My_Error");
		driver.findElement(By.xpath("//span[@id='cart-total']")).click();
		driver.findElement(By.xpath("//*[@title='Remove']")).click();
		Thread.sleep(2000);
		String secondActual = driver.findElement(By.xpath("//span[@id='cart-total']")).getText();
		String secondExpected = "0 item(s) - $0.00";
		Assert.assertEquals(secondActual, secondExpected, "My_Error");
	}

	@AfterSuite
	public void turnOff() {
		driver.quit();
	}
}
