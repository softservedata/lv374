package com.softserve.edu.ukrnet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.ukrnet.data.User;


public class LoginPage {

	private WebDriver driver;
	
	private WebElement emailField;
	
	private WebElement passwordField;
	
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		emailField = driver.findElement(By.xpath("//input[@id='id-l']"));
		passwordField = driver.findElement(By.xpath("//input[@id='id-p']"));
		loginButton = driver.findElement(By.cssSelector("div.button__content"));
	}
	
	// Page Object
	// emailField
	public WebElement getEmailField() {
		return emailField;
	}

	public String getEmailFieldText() {
		return getEmailField().getText();
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

	// passwordField
	public WebElement getPasswordField() {
		return passwordField;
	}

	public String getPasswordFieldText() {
		return getPasswordField().getText();
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

	// loginButton
	public WebElement getLoginButton() {
		return loginButton;
	}

	public String getLoginButtonText() {
		return getLoginButton().getText();
	}

	public void clickLoginButton() {
		getLoginButton().click();
	}

	//functional
	
	private void login(User user) {
		clickEmailField();
		clearEmailField();
		setEmailField(user.getEmail());
		clickPasswordField();
		clearPasswordField();
		setPasswordField(user.getPassword());
		clickLoginButton();
	}
	
	//business
	
//	public 
}
