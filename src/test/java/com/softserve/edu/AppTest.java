package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	//@Test
	public void testApp() {
		Assert.assertTrue(true);
	}	

	/**
	 * Positive test.
	 * Used technique: State transition.
	 * This method check if right goods added to wish list.
	 */
	@Test//(dataProvider = "concurrencyData")
	public void checkSeleniumIDE() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/home/milnik/SoftServe/GitProject/lv374/target/test-classes/chromedriver-linux-64bit");
//		System.out.println("this.getClass().getResource(\"/chromedriver-linux-64bit\").getPath() = "
//				+ this.getClass().getResource("//chromedriver-linux-64bit").getPath());
//		System.setProperty("webdriver.chrome.driver",
//				this.getClass().getResource("//chromedriver-linux-64bit").getPath().substring(1));
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		driver.get("http://taqc-opencart.epizy.com/index.php?route=common/home");
		//
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		//
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		//
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("milniklalka07@gmaik.com");
		//
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("krappa123" + Keys.ENTER);
		//
		driver.findElement(By.xpath("//*[@id='logo']/a/img")).click();
		//
		driver.findElement(By.cssSelector("#content > div.row > div:nth-child(2) > div > div.button-group > button:nth-child(2)")).click();
		//
		driver.findElement(By.xpath("//*[@id=\'wishlist-total\']")).click();
		//
		String expected = "iPhone 3";
		String actual = driver.findElement(By.cssSelector("#content > div.table-responsive > table > tbody > tr > td:nth-child(2) > a")).getText();
		Assert.assertEquals(actual, expected, "My_Error");
		//
		driver.quit();
	}

}
