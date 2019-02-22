package com.softserve.edu.mailbox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.mailbox.data.MailUser;
import com.softserve.edu.mailbox.pages.boxes.IncomesLettersPage;

public class MailLoginPage {

	public static String ENGLISH_ERROR_MESSAGE = "Wrong data";
	public static String RUSSIAN_ERROR_MESSAGE = "Неправильные данные";
	public static String UKRAINIAN_ERROR_MESSAGE = "Неправильні дані";
	public static String TAG_ATTRIBUTE_VALUE = "value";
	public static String ACTUAL_ERROR_MESSAGE = "";

	private WebDriver driver;

	private WebElement loginField;

	private WebElement passwordField;

	private WebElement loginButton;

	public MailLoginPage(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		loginField = driver.findElement(By.xpath("//input[@id='id-l']"));
		passwordField = driver.findElement(By.xpath("//input[@id='id-p']"));
		loginButton = driver.findElement(By.cssSelector(".button.button_style-main"));
	}

	// pageobject

	// login field

	public WebElement getLoginField() {
		return loginField;
	}

	public String getLoginFieldText() {
		return getLoginField().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clickLoginField() {
		getLoginField().click();
	}

	public void clearLoginField() {
		getLoginField().clear();
	}

	public void setLoginField(String text) {
		getLoginField().sendKeys(text);
	}

	// password field

	public WebElement getPasswordField() {
		return passwordField;
	}

	public String getPasswordFieldText() {
		return getPasswordField().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clickPasswordField() {
		getPasswordField().click();
	}

	public void clearPasswordField() {
		getPasswordField().clear();
	}

	public void setPasswordField(String text) {
		getPasswordField().sendKeys(text);
	}

	// login button

	public WebElement getLoginButton() {
		return loginButton;
	}

	public String getLoginButtonText() {
		return getLoginButton().getText();
	}

	public void clickLoginButton() {
		getLoginButton().click();
	}

	// functional

	private void login(MailUser user) {
		clickLoginField();
		clearLoginField();
		setLoginField(user.getUsername());
		clearPasswordField();
		setPasswordField(user.getPassword());
		clickLoginButton();
	}

	// business logic

	public IncomesLettersPage successfullLogin(MailUser user) {
		login(user);
		return new IncomesLettersPage(driver);
	}

	public MailLoginPage unsuccessfullLogin(MailUser user) {
		login(user);
		ACTUAL_ERROR_MESSAGE = driver.findElement(By.cssSelector("p.form__error.form__error_fail")).getText();
		return this;
	}
}
