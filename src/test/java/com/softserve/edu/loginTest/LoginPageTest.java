package com.softserve.edu.loginTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The {@code LoginPageTest} testing login functionality
 * 
 * @author Yaroslav
 *
 */
public class LoginPageTest extends SetingTest {

	
	/**
	 * Positive test
	 * Equivalence partition
	 * try to login with correct data
	 * @throws InterruptedException 
	 */
	@Test
	public void correctLoginTest() throws InterruptedException {
		openLoginPage();
		Thread.sleep(1000);
		String loginPage = driver.getCurrentUrl();
		inputData(getField("//input[contains(@id, 'input-email')]"), "opencart_test@ukr.net");
		inputData(getField("//input[contains(@id, 'input-password')]"), "qwerty" + Keys.ENTER);
		Thread.sleep(1000);
		String actualPage = driver.getCurrentUrl();
		Assert.assertNotEquals(loginPage, actualPage);
	}

	/**
	 * Negative test
	 * try to log in with incorrect data
	 * @throws InterruptedException 
	 */
	@Test
	public void incorrectLoginTest() throws InterruptedException {
		openLoginPage();
		Thread.sleep(1000);
		String loginPage = driver.getCurrentUrl();
		inputData(getField("//input[contains(@id, 'input-email')]"), "opencart_test@ukr.net");
		inputData(getField("//input[contains(@id, 'input-password')]"), "123" + Keys.ENTER);
		Thread.sleep(1000);
		String actualPage = driver.getCurrentUrl();
		Assert.assertEquals(loginPage, actualPage);
	}

}
