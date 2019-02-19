package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfullForgottenPasswordPage extends LoginPage {

	public static final String ALERT_MESSAGE = " An email with a confirmation link has been sent your email address.";

	private WebElement alertMessage;

	public SuccessfullForgottenPasswordPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		alertMessage = driver.findElement(By.cssSelector("div.alert.alert-success"));
	}

	public WebElement getAlertMessage() {
		return alertMessage;
	}

	public String getAlertMessageText() {
		return getAlertMessage().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

}
