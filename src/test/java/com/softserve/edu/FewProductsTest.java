package com.softserve.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class FewProductsTest {

	private WebDriver driver;

	/**
	 * Positive test. Used technique: State transition. This method check if right
	 * products added to wish list.
	 */
	@Test
	public void testFewProducts() throws Exception {
		driver.findElement(By.cssSelector("h4 > a[href*='id=40']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-default']/i[@class='fa fa-heart']")).click();
		driver.findElement(By.xpath("//*[@id='logo']/a")).click();
		driver.findElement(By.cssSelector("h4 > a[href*='id=43']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-default']/i[@class='fa fa-heart']")).click();
		driver.findElement(By.cssSelector("#wishlist-total")).click();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("MacBook");
		expected.add("iPhone");
		ArrayList<String> actual = new ArrayList<String>();
		actual.add(driver
				.findElement(By.cssSelector("table.table-bordered > tbody > tr > td.text-left > a[href*='id=43']"))
				.getText());
		actual.add(driver
				.findElement(By.cssSelector("table.table-bordered > tbody > tr > td.text-left > a[href*='id=40']"))
				.getText());
		Assert.assertEquals(actual, expected);
	}

	/**
	 * This method create the instance of WebDriver variable, then open opencart in
	 * browser and login in it.
	 */
	@BeforeClass
	public void setUpDriverAndLogin() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-linux-64bit").getPath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://127.0.1.1/opencart/upload/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement(By.id("input-email")).sendKeys("milniklalka07@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("qwerty" + Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='logo']/a")).click();

	}

	/**
	 * This method delete product from wishlist and destroying the instance of
	 * WebDriver. It closes all Browser Windows and safely ends the session.
	 */
	@AfterClass
	public void Quit() {
		driver.findElement(By.cssSelector("td.text-right >a[href*='40']")).click();
		driver.findElement(By.cssSelector("td.text-right >a[href*='43']")).click();
		driver.quit();
	}

}
