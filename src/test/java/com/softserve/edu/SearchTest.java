package com.softserve.edu;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	/**
	 * Tests for Opencart search functional.
	 */
public class SearchTest {
	WebDriver driver;
	/**
	 * Before Class. Setup Chrome WebDriver before first test.
	 */
	@BeforeClass
	public void DriverSetup() {
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * After Class. Stops the Chrome WebDriver.
	 */
	@AfterClass
	public void DriverQuit() {
		driver.quit();
	}
	/**
	 * Before Method. Switch over to main page before each test.
	 */
	@BeforeMethod
	public void GoToMain() {
		driver.get("http://localhost/index.php");
	}
	/**
	 * State Transition technique. Positive test. Compare search query and product
	 * name.
	 */
	@Test
	public void checkSearchResult() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("iPhone" + Keys.ENTER);
		String expected = "iPhone";
		String actual = driver
				.findElement(
						By.xpath("//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iPhone')]"))
				.getText();
		Assert.assertEquals(actual, expected, "Wrong search result");
	}
	/**
	 * State Transition technique. Positive test. Checks message for non-found
	 * product.
	 */
	@Test
	public void checkNonFoundMessage() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("Xiaomi" + Keys.ENTER);
		String expected = "There is no product that matches the search criteria.";
		String actual = driver.findElement(By.xpath("//*[@id='content']/p[2]")).getText();
		Assert.assertEquals(actual, expected, "Missing error message");
	}
	/**
	 * State Transition technique. Positive test. Checks the product sort.
	 */
	@Test
	public void checkSort() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("Samsung" + Keys.ENTER);
		driver.findElement(By.xpath("//select[@id='input-sort']")).click();
		driver.findElement(By.xpath("//*[@id='input-sort']/option[5]")).click();
		String expected = "Ex Tax: $200.00";
		String actual = driver.findElement(By.xpath("//span[@class='price-tax']")).getText();
		Assert.assertEquals(actual, expected, "Wrong filter work");
	}
	/**
	 * State Transition technique. Positive test. Checks if the search query is
	 * actually transmitted to the keywords field.
	 */
	@Test
	public void checkSearchAndKeyword() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("samsung" + Keys.ENTER);
		String expected = "samsung";
		String actual = driver.findElement(By.xpath("//*[@id='input-search']")).getAttribute("value");
		Assert.assertEquals(actual, expected, "Wrong keyword");
	}
	/**
	 * State Transition technique. Positive test. Check the search field for special
	 * characters.
	 */
	@Test
	public void checkSpecialCharacters() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("%" + Keys.ENTER);
		String expected = "There is no product that matches the search criteria.";
		String actual = driver.findElement(By.xpath("//*[@id='content']/p[2]")).getText();
		Assert.assertEquals(actual, expected, "Wrong characters entered");
	}
	/**
	 * State Transition technique. Positive test. Verify that all products with the
	 * same name are actually displayed.
	 */
	@Test
	public void checkForSameName() throws Exception {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys("Ipod" + Keys.ENTER);
		ArrayList<String> ExpectedProductList = new ArrayList<String>();
		ExpectedProductList.add("iPod Classic");
		ExpectedProductList.add("iPod Nano");
		ExpectedProductList.add("iPod Shuffle");
		ExpectedProductList.add("iPod Touch");
		ArrayList<String> ActualProductList = new ArrayList<String>();
		ActualProductList.add(driver
				.findElement(By.xpath(
						"//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iPod Classic')]"))
				.getText());
		ActualProductList.add(driver
				.findElement(By.xpath(
						"//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iPod Nano')]"))
				.getText());
		ActualProductList.add(driver
				.findElement(By.xpath(
						"//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iPod Shuffle')]"))
				.getText());
		ActualProductList.add(driver
				.findElement(By.xpath(
						"//div[contains(@class,'product-layout product-grid')]//a[contains(text(),'iPod Touch')]"))
				.getText());
		Assert.assertEquals(ActualProductList, ExpectedProductList, "Wrong search result");
	}
}
