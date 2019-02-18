package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends RightLoginUnit {

	public static final String TEXT_DANGER = "Password must be between 4 and 20 characters!";
	
	private WebElement passwordField;
	private WebElement confirmPasswordField;
	private WebElement continueButton;
	private WebElement backButton;

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		passwordField = driver.findElement(By.id("input-password"));
		confirmPasswordField = driver.findElement(By.id("input-confirm"));
		continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
		backButton = driver.findElement(By.xpath("//div//a[text()='Back']"));
	}

	// page object

	// password field

	public WebElement getPasswordField() {
		return passwordField;
	}

	public String getPasswordFieldText() {
		return getPasswordField().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setPasswordField(String text) {
		getPasswordField().sendKeys(text);
	}

	public void clearPasswordField() {
		getPasswordField().clear();
	}

	public void clickPasswordField() {
		getPasswordField().click();
	}

	// confirm password field

	public WebElement getConfirmPasswordField() {
		return confirmPasswordField;
	}

	public String getConfirmPasswordFieldText() {
		return getConfirmPasswordField().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setConfirmPasswordField(String text) {
		getConfirmPasswordField().sendKeys(text);
	}

	public void clearConfirmPasswordField() {
		getConfirmPasswordField().clear();
	}

	public void clickConfirmPasswordField() {
		getConfirmPasswordField().click();
	}

	// continue button

	public WebElement getContinueButton() {
		return continueButton;
	}

	public String getContinueButtonText() {
		return getContinueButton().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clickContinueButton() {
		getContinueButton().click();
	}

	// back button

	public WebElement getBackButton() {
		return backButton;
	}

	public String getBackButtonText() {
		return getBackButton().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clickBackButton() {
		getBackButton().click();
	}

	// functional

	private void inputPassword(String password) {
		clickPasswordField();
		clearPasswordField();
		setPasswordField(password);
		clickConfirmPasswordField();
		clearConfirmPasswordField();
		setConfirmPasswordField(password);
		clickContinueButton();
	}
	
	// business logic

	public MyAccountPage changeValidPassword(String password) {
		inputPassword(password);
		return new MyAccountPage(driver);
	}
	
	public ChangePasswordPage setInvalidPassword(String password) {
		inputPassword(password);
		return new ChangePasswordPage(driver);
	}
	
}
