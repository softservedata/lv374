package com.softserve.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AddToCartTest {

	private WebDriver driver;

	/**
	 * Positive test. Used technique: State transition. This method test if product
	 * added to cart from wishlist.
	 */
	@Test
	public void testAddingToCart() throws Exception {
		driver.findElement(By.xpath("//tr[1]/td[6]/button")).click();
		driver.findElement(By.cssSelector("#cart > button")).click();
		String expected = "iPhone";
		String actual = driver
				.findElement(By.cssSelector("table.table-striped > tbody > tr > td.text-left > a[href*='id=40']"))
				.getText();
		Assert.assertEquals(actual, expected);
	}

	/**
	 * Positive test. Used technique: State transition. This method test if
	 * redirects to product if needed to fill up required fields to add product to
	 * cart.
	 */
	@Test
	public void testAddingToCartWithRedirect() throws Exception {
		driver.findElement(By.xpath("//tr[2]/td[6]/button")).click();
		String expected = "Apple Cinema 30\"";
		String actual = driver.findElement(By.cssSelector("div.col-sm-4 > h1")).getText();
		Assert.assertEquals(actual, expected);
	}

	/**
	 * This method redirect to wishlist.
	 */
	@BeforeMethod
	public void redirectToWishList() {
		driver.findElement(By.cssSelector("#wishlist-total")).click();
	}

	/**
	 * This method create the instance of WebDriver variable, then open opencart in
	 * browser, login in it and add products that are being tested to wishlist.
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
		driver.findElement(By.cssSelector("h4 > a[href*='id=40']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-default']/i[@class='fa fa-heart']")).click();
		driver.findElement(By.xpath("//*[@id='logo']/a")).click();
		driver.findElement(By.cssSelector("h4 > a[href*='id=42']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-default']/i[@class='fa fa-heart']")).click();
	}

	/**
	 * This method delete product from wishlist and destroying the instance of
	 * WebDriver. It closes all Browser Windows and safely ends the session.
	 */
	@AfterClass
	public void Quit() {
		driver.findElement(By.cssSelector("#wishlist-total")).click();
		driver.findElement(By.cssSelector("td.text-right >a[href*='40']")).click();
		driver.findElement(By.cssSelector("td.text-right >a[href*='42']")).click();
		driver.quit();
	}

}
