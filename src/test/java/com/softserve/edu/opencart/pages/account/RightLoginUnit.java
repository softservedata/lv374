package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RightLoginUnit extends RightMenuUnit {

	private WebElement editAccount;
	private WebElement password;
	private WebElement logout;
	
	
	public RightLoginUnit(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private void initElements() {
		editAccount = driver.findElement(By.cssSelector("div.list-group > a[href*='route=account/edit']"));
		password = driver.findElement(By.cssSelector("div.list-group > a[href*='route=account/password']"));
		logout = driver.findElement(By.cssSelector("div.list-group > a[href*='route=account/logout']"));
	}

	// Page Object

	// editAccount
	public WebElement getEditAccount() {
		return editAccount;
	}

	public String getEditAccountText() {
		return getEditAccount().getText();
	}

	public void clickEditAccount() {
		getEditAccount().click();
	}
	
	// password
	
	public WebElement getPassword() {
		return password;
	}
	
	public String getPasswordText() {
		return getPassword().getText();
	}
	
	public void clickPassword() {
		getPassword().click();
	}
	
	public WebElement getLogout() {
		return logout;
	}
	
	public String getLogoutText() {
		return getLogout().getText();
	}
	
	public void clickLogout() {
		getLogout().click();
	}
	
	// Functional

	// Business Logic
	
	public EditAccountPage gotoEditAccountPage() {
		clickEditAccount();
        return new EditAccountPage(driver);
    }
	
	public ChangePasswordPage gotoPasswordPage() {
		clickPassword();
		return new ChangePasswordPage(driver);
	}
	
	public AccountLogoutPage gotoLogoutPage() {
		clickLogout();
		return new AccountLogoutPage(driver);
	}
	
}
