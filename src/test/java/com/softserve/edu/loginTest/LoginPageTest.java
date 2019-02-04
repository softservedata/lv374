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
	 * try to login with correct data
	 */
	@Test
	public void correctLoginTest() {
		openLoginPage();
		String loginPage = driver.getCurrentUrl();
		inputData(getField("//input[contains(@id, 'input-email')]"), "opencart_test@ukr.net");
		inputData(getField("//input[contains(@id, 'input-password')]"), "qwerty" + Keys.ENTER);
		String actualPage = driver.getCurrentUrl();
		Assert.assertNotEquals(loginPage, actualPage);
	}

	/**
	 * try to log in with incorrect data
	 */
	@Test
	public void incorrectLoginTest() {
		openLoginPage();
		String loginPage = driver.getCurrentUrl();
		inputData(getField("//input[contains(@id, 'input-email')]"), "opencart_test@ukr.net");
		inputData(getField("//input[contains(@id, 'input-password')]"), "123" + Keys.ENTER);
		String actualPage = driver.getCurrentUrl();
		Assert.assertEquals(loginPage, actualPage);
	}

}
