package com.softserve.edu.loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends SetingTest {

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

	private void newPass(String password) {
		inputData(getField("//input[contains(@id, 'input-password')]"), password);
		inputData(getField("//input[contains(@id, 'input-confirm')]"), password + Keys.ENTER);
	}
	
	private void login(String login, String password) {
		inputData(getField("//input[contains(@id, 'input-email')]"), login);
		inputData(getField("//input[contains(@id, 'input-password')]"), password + Keys.ENTER);
	}

	private WebElement changePasswordPage() {
		return driver.findElement(By.xpath("//a[text()='Password']"));
	}

}
