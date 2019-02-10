package com.softserve.edu.loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends SetingTest {

	/**
	 * Negative test equivalence partition
	 * change too long password
	 * @throws InterruptedException 
	 */
	@Test
	public void changePasswordTest3() throws InterruptedException {
		openLoginPage();
		Thread.sleep(1000);
		login("opencart_test@ukr.net", "qwerty");
		Thread.sleep(1000);
		changePasswordPage().click();
		String url = driver.getCurrentUrl();
		newPass("qwertyuiopasdfghjklzxcvbnm");
		Thread.sleep(1000);
		String newUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, newUrl);
	}
	
	/**
	 * negative test boundary value
	 * change too short password
	 * @throws InterruptedException 
	 */
	@Test
	public void changePasswordTest2() throws InterruptedException {
		openLoginPage();
		Thread.sleep(1000);
		login("opencart_test@ukr.net", "qwerty");
		Thread.sleep(1000);
		changePasswordPage().click();
		String url = driver.getCurrentUrl();
		newPass("qwe");
		Thread.sleep(1000);
		String newUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, newUrl);
	}

	/**
	 * Positive test equivalence partition
	 * change the same password
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void changePasswordTest1() throws InterruptedException {
		openLoginPage();
		Thread.sleep(1000);
		login("opencart_test@ukr.net", "qwerty");
		Thread.sleep(1000);
		changePasswordPage().click();
		String url = driver.getCurrentUrl();
		newPass("qwerty");
		Thread.sleep(1000);
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
