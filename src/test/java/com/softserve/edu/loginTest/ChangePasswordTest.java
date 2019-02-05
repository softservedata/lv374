package com.softserve.edu.loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends SetingTest {

	/**
	 * change too long password
	 */
	@Test
	public void changePasswordTest3() {
		openLoginPage();
		login("opencart_test@ukr.net", "qwerty");
		changePasswordPage().click();
		String url = driver.getCurrentUrl();
		newPass("qwertyuiopasdfghjklzxcvbnm");
		String newUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, newUrl);
	}
	
	/**
	 * change too short password
	 */
	@Test
	public void changePasswordTest2() {
		openLoginPage();
		login("opencart_test@ukr.net", "qwerty");
		changePasswordPage().click();
		String url = driver.getCurrentUrl();
		newPass("qwe");
		String newUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, newUrl);
	}

	/**
	 * change the same password
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void changePasswordTest1() throws InterruptedException {
		openLoginPage();
		login("opencart_test@ukr.net", "qwerty");
		changePasswordPage().click();
		String url = driver.getCurrentUrl();
		newPass("qwerty");
		String newUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(url, newUrl);
	}

	/**
	 * method set new password
	 * @param password password to be set
	 */
	private void newPass(String password) {
		inputData(getField("//input[contains(@id, 'input-password')]"), password);
		inputData(getField("//input[contains(@id, 'input-confirm')]"), password + Keys.ENTER);
	}

	/**
	 * method login in opencart
	 * @param login 
	 * @param password
	 */
	private void login(String login, String password) {
		inputData(getField("//input[contains(@id, 'input-email')]"), login);
		inputData(getField("//input[contains(@id, 'input-password')]"), password + Keys.ENTER);
	}

	/**
	 * find reference of change password button link
	 * @return password button reference
	 */
	private WebElement changePasswordPage() {
		return driver.findElement(By.xpath("//a[text()='Password']"));
	}

}
