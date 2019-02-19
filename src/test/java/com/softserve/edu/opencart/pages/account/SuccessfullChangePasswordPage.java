package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfullChangePasswordPage extends MyAccountPage {

	public static final String ALERT_MESSAGE = " Success: Your password has been successfully updated.";

	private WebElement alertMessage;

	public SuccessfullChangePasswordPage(WebDriver driver) {
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
		return getAlertMessage().getText();
	}

}
