package com.softserve.edu.loginPageTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The {@code LoginTest} class contains test methods that test login page with
 * legal and illegal login data
 * 
 * @version 1.0
 * @author Yaroslav
 *
 */
public class LoginTest {

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

	/**
	 * called after every test method logging out account
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void tearDownMethod() throws Exception {
		driver.get("http://192.168.227.130/opencart/upload/index.php?route=account/logout");
	}

	/**
	 * close driver and exit from browser
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	/**
	 * negative test check login with wrong login and password
	 */
	@Test
	public void checkLogin() {
		openLoginPage();
		sendKeysToField("email", "correct@email.com");
		sendKeysToField("password", "123" + Keys.ENTER);
		String expected = "Warning: No match for E-Mail Address and/or Password.";
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger')]")).getText();
		Assert.assertEquals(actual, expected);
	}

	/**
	 * negative test try to sigh in with correct user name and wrong password
	 */
	@Test
	public void wrongPasswordTest() {
		openLoginPage();
		sendKeysToField("email", "slavik_klymovets@ukr.net");
		sendKeysToField("password", "123" + Keys.ENTER);
		String expected = "Warning: No match for E-Mail Address and/or Password.";
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger')]")).getText();
		Assert.assertEquals(actual, expected);
	}

	/**
	 * positive test try to sign in with correct user name and password
	 */
	@Test
	public void correctDataTest() {
		openLoginPage();
		sendKeysToField("email", "slavik_klymovets@ukr.net");
		sendKeysToField("password", "qwerty" + Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(@title, 'My Account')]")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	public void sendKeysToField(String field, String keys) {
		driver.findElement(By.name(field)).click();
		driver.findElement(By.name(field)).clear();
		driver.findElement(By.name(field)).sendKeys(keys);
	}

	public void openLoginPage() {
		driver.findElement(By.xpath("//a[contains(@title, 'My Account')]")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
	}

}
