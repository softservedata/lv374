package com.softserve.edu.loginPageTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The {@code ForgotPasswordTest} tests forgot password functional
 * 
 * @version 1.0
 * @author Yaroslav
 *
 */
public class ForgotPasswordTest {

	private WebDriver driver;

	/**
	 * Method runs one time when class starts. Initialize driver and open browser at
	 * main page of tested source
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public void setUp() throws Exception {
		System.out.println("this.getClass().getResource(\"/chromedriver-windows-32bit.exe\").getPath() = "
				+ this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
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
		driver.get("http://192.168.227.130/opencart/upload/");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	/**
	 * test forgot password page functionality
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void forgotPasswordTest() throws InterruptedException {
		forgotPasswordPage();
		sendKeysToField("email", "slavik_klymovets@ukr.net" + Keys.ENTER);
		List<String> tabs = openNewTab(
				"https://accounts.ukr.net/login?client_id=ACz08jmzte0zdKxL2zFU&drop_reason=logout");
		emailLogin("slavik_klymovets@ukr.net", "i5p363V2");
		Thread.sleep(10000);
	}

	/**
	 * trying to input in email field non-existed email adres
	 */
	@Test
	public void forgotPasswordNegativeTest() {
		forgotPasswordPage();
		sendKeysToField("email", "123@mail.com" + Keys.ENTER);
		String expected = "Warning: The E-Mail Address was not found in our records, please try again!";
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger')]")).getText();
		Assert.assertEquals(actual, expected);
	}

	/**
	 * open new tab in browser and switch to it
	 * 
	 * @param url link to be opened
	 * @return list of all opened tabs
	 */
	public ArrayList<String> openNewTab(String url) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		driver.get(url);
		return tabs;
	}

	/**
	 * log in to ukr.net
	 * 
	 * @param username email box
	 * @param password pass to this box
	 */
	public void emailLogin(String username, String password) {
		sendKeysByXpath("//input[contains(@id, 'id-l')]", username);
		sendKeysByXpath("//input[contains(@id, 'id-p')]", password + Keys.ENTER);
	}

	/**
	 * send keys to inputed field founded by xpath
	 * 
	 * @param field field to send key
	 * @param keys  keys to be sends
	 */
	public void sendKeysByXpath(String field, String keys) {
//		driver.findElement(By.xpath(field)).click();
		driver.findElement(By.xpath(field)).clear();
		driver.findElement(By.xpath(field)).sendKeys(keys);
	}

	/**
	 * send keys to inputed field
	 * 
	 * @param field field to send key
	 * @param keys  keys to be sends
	 */
	public void sendKeysToField(String field, String keys) {
		driver.findElement(By.name(field)).click();
		driver.findElement(By.name(field)).clear();
		driver.findElement(By.name(field)).sendKeys(keys);
	}

	/**
	 * opens forgot password page
	 */
	public void forgotPasswordPage() {
		driver.findElement(By.xpath("//a[contains(@title, 'My Account')]")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//a[text()='Forgotten Password']")).click();
	}

}