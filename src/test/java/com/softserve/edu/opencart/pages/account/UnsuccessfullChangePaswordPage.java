package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfullChangePaswordPage extends ChangePasswordPage {

	public UnsuccessfullChangePaswordPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	public static final String TEXT_DANGER = "Password must be between 4 and 20 characters!";

	private WebElement alertMessage;

	private void initElements() {
		alertMessage = driver.findElement(By.cssSelector(".text-danger"));
	}

	// page obgect

	public WebElement getAlertMessage() {
		return alertMessage;
	}

	public String getAlertMessageText() {
		return alertMessage.getText();
	}

}
