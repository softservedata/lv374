package com.softserve.edu;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for Opencart.
 */
public class AppTest {
	WebDriver driver;

	@BeforeClass
	public void DriverSetup() {
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
	public void GoToMain() {
		driver.get("http://localhost/index.php");
	}

	@Test
	public void checkSeleniumIDE() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("iPhone" + Keys.ENTER);
		String expected = "iPhone";
		String actual = driver.findElement(By.xpath("//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iPhone')]")).getText();
		Assert.assertEquals(actual, expected, "Wrong search result");
	}

	@Test
	public void checkSeleniumIDE2() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("Xiaomi" + Keys.ENTER);

		String expected = "There is no product that matches the search criteria.";
		String actual = driver.findElement(By.xpath("//*[@id='content']/p[2]")).getText();
		Assert.assertEquals(actual, expected, "Missing error message");
	
	}
	@Test
	public void checkSeleniumIDE3() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("Samsung" + Keys.ENTER);
		driver.findElement(By.xpath("//select[@id='input-sort']")).click();
		driver.findElement(By.xpath("//*[@id='input-sort']/option[5]")).click();
		String expected = "Ex Tax: $200.00";
		String actual = driver.findElement(By.xpath("//span[@class='price-tax']")).getText();
		Assert.assertEquals(actual, expected, "Wrong filter work");
	}

	@Test
	public void checkSeleniumIDE4() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("samsung" + Keys.ENTER);
		String expected = "samsung";
		String actual = driver.findElement(By.xpath("//*[@id='input-search']")).getAttribute("value");
		Assert.assertEquals(actual, expected, "Wrong keyword");
	}
	
	@Test
	public void checkSeleniumIDE5() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("%" + Keys.ENTER);
		String expected = "There is no product that matches the search criteria.";
		String actual = driver.findElement(By.xpath("//*[@id='content']/p[2]")).getText();
		Assert.assertEquals(actual, expected, "Wrong characters entered");
	}
	@Test
	public void checkSeleniumIDE6() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("%" + Keys.ENTER);
		ArrayList<String> ExpectedProductList = new ArrayList<String>(); 
		ExpectedProductList.add("iPod Classic");
		ExpectedProductList.add("iPod Nano");
		ExpectedProductList.add("iPod Shuffle");
		ExpectedProductList.add("iPod Touch");
		ArrayList<String> ActualProductList = new ArrayList<String>(); 
		ActualProductList.add(driver.findElement(By.xpath("//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iPod Classic')]")).getText());
		ActualProductList.add(driver.findElement(By.xpath("//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iPod Nano')]")).getText());
		ActualProductList.add(driver.findElement(By.xpath("//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iPod Shuffle')]")).getText());
		ActualProductList.add(driver.findElement(By.xpath("//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iPod Touch')]")).getText());
		Assert.assertEquals(ActualProductList, ExpectedProductList, "Wrong characters entered a");
	}
}

