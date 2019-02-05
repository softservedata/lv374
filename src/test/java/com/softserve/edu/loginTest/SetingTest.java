package com.softserve.edu.loginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * The {@code SetingTest} contains only {@code setUp} and {@code tearDown}
 * methods that are using between test methods
 * 
 * @author Yaroslav
 *
 */
public class SetingTest {

	protected WebDriver driver;

	/**
	 * Method runs one time when class starts. Initialize driver and open browser at
	 * main page of tested source
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * called before every test method. Get browser to main page
	 * 
	 * @throws Exception
	 */
	@BeforeMethod
	public void setUpMethod() throws Exception {
		driver.get("http://localhost/opencart/upload/");
	}

	/**
	 * using after every test method trying to logout from account
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void tearDownMethod() throws Exception {
		driver.get("http://localhost/opencart/upload/index.php?route=account/logout");
	}

	/**
	 * called in the end of all tests and just close web driver
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	/**
	 * enter some data to web element
	 * @param element reference of web element
	 * @param data data to be inputed
	 */
	public void inputData(WebElement element, String data) {
		element.click();
		element.clear();
		element.sendKeys(data);
	}

	/**
	 * find web element by xpath
	 * @param xpath path on the page of web element
	 * @return reference of web element
	 */
	public WebElement getField(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * method open login page
	 */
	public void openLoginPage() {
		driver.findElement(By.xpath("//a[contains(@title, 'My Account')]")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
	}

}
