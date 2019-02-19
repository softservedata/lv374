package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfullForgottenPasswordPage extends ForgottenPasswordPage {

	public static final String ALERT_MESSAGE = " Warning: The E-Mail Address was not found in our records, please try again!";

	private WebElement alertMessage;

	public UnsuccessfullForgottenPasswordPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		alertMessage = driver.findElement(By.cssSelector("div.alert.alert-danger"));
	}

	public WebElement getAlertMessage() {
		return alertMessage;
	}
	
	public String getAlertMessageText() {
		return getAlertMessage().getAttribute(TAG_ATTRIBUTE_VALUE);
	}
	
}
