package com.softserve.edu.loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ChangePasswordTest extends SetingTest {

	public void changePasswordTest1() {
		
	}

	private void login(String login, String password) {
		inputData(getField("//input[contains(@id, 'input-email')]"), login);
		inputData(getField("//input[contains(@id, 'input-password')]"), password);
	}

	private WebElement changePasswordPage() {
		return driver.findElement(By.xpath("//a(text()='Password')"));
	}

}
