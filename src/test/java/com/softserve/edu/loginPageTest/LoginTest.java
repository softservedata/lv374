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
 * legal and illegal logen data
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
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://taqc-opencart.epizy.com");
	}

	@BeforeMethod
	public void setUpMethod() throws Exception {
		driver.get("http://taqc-opencart.epizy.com");
		driver.findElement(By.xpath("//a[contains(@title, 'My Account')]")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
	}

	/**
	 * called after every test method logging out account
	 * 
	 * @throws Exception
	 */
	@AfterMethod
	public void tearDownMethod() throws Exception {
		driver.get("http://taqc-opencart.epizy.com/index.php?route=account/logout");
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
		driver.findElement(By.xpath("//a[contains(@title, 'My Account')]")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("correct@email.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123" + Keys.ENTER);
		String expected = "Warning: No match for E-Mail Address and/or Password.";
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger')]")).getText();
		Assert.assertEquals(actual, expected);
	}

	/**
	 * negative test try to sigh in with correct user name and wrong password
	 */
	@Test
	public void wrongPasswordTest() {
		driver.findElement(By.xpath("//a[contains(@title, 'My Account')]")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("qwerty@mail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123" + Keys.ENTER);
		String expected = "Warning: No match for E-Mail Address and/or Password.";
		String actual = driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger')]")).getText();
		Assert.assertEquals(actual, expected);
	}

	/**
	 * positive test try to sign in with correct user name and password
	 */
	@Test
	public void correctDataTest() {
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("qwerty@mail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("qwerty" + Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(@title, 'My Account')]")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
