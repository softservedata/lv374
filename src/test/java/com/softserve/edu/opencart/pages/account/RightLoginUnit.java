package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.User;

public class RightLoginUnit extends RightMenuUnit {

	private WebElement editAccount;
	
	public RightLoginUnit(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private void initElements() {
		editAccount = driver.findElement(By.cssSelector("div.list-group > a[href*='route=account/edit']"));
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
	
	// Functional

	// Business Logic
	
	public EditAccountPage gotoEditAccountPage() {
		clickEditAccount();
        return new EditAccountPage(driver);
    }

}
