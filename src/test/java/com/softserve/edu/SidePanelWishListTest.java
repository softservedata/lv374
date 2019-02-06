package com.softserve.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SidePanelWishListTest {

	private WebDriver driver;

	/**
	 * Positive test. Used technique: State transition.
	 */
	@Test
	public void testSidePanelWishList() throws Exception {
		driver.findElement(By.cssSelector("#wishlist-total")).click();
		driver.findElement(By.cssSelector("a.list-group-item[href*='wishlist']")).click();
		String actual = driver.getCurrentUrl();
		Assert.assertTrue(actual.contains("index.php?route=account/wishlist"));
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
	}

	/**
	 * This method destroying the instance of WebDriver. It closes all Browser
	 * Windows and safely ends the session.
	 */
	@AfterClass
	public void Quit() {
		driver.quit();
	}

}
