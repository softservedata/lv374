package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IUser;

public class ForgottenPasswordPage extends RightLogoutUnit {

	public static final String INCORRECT_DATA_INPUT = " Warning: The E-Mail Address was not found in our records, please try again!";
	public static final String CORRECT_DATA_INPUT = " An email with a confirmation link has been sent your email address.";

	private WebElement emailField;
	private WebElement continueButton;
	private WebElement backButton;

	public ForgottenPasswordPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		emailField = driver.findElement(By.id("input-email"));
		continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
		backButton = driver.findElement(By.cssSelector(".btn btn-default"));
	}

	// Page Object

	// email field
	public WebElement getEmailField() {
		return emailField;
	}

	public String getEmailFieldText() {
		return getEmailField().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setEmailField(String text) {
		getEmailField().sendKeys(text);
	}

	public void clearEmailField() {
		getEmailField().clear();
	}

	public void clickEmailField() {
		getEmailField().click();
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

	private void fillEmailForm(IUser user) {
		clickEmailField();
		clearEmailField();
		setEmailField(user.getEmail());
		clickContinueButton();
	}

	// business logic

	public ForgottenPasswordPage inputIncorrectUser(IUser invalidUser) {
		fillEmailForm(invalidUser);
		return this;
	}

	public LoginPage inputCorrectUser(IUser validUser) {
		fillEmailForm(validUser);
		return new LoginPage(driver);
	}

	public LoginPage gotoLoginPage() {
		clickBackButton();
		return new LoginPage(driver);
	}

}
