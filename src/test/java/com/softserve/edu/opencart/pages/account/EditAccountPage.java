package com.softserve.edu.opencart.pages.account;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAccountPage extends RightLoginUnit {

	private WebElement firstname;
	private WebElement continueButton;
	
	public EditAccountPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		firstname = driver.findElement(By.id("input-firstname"));
		continueButton = driver.findElement(By.cssSelector("div.pull-right > input.btn.btn-primary"));
	}

	// Page Object

	// firstname
	public WebElement getFirstname() {
		return firstname;
	}

	public String getFirstnameText() {
		return getFirstname().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setFirstnameField(String text) {
		getFirstname().sendKeys(text);
	}

	public void clearFirstname() {
		getFirstname().clear();
	}

	public void clickFirstname() {
		getFirstname().click();
	}
	
	// continueButton
	public WebElement getContinueButton() {
		return continueButton;
	}

	public String getContinueButtonText() {
		return getContinueButton().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clickContinueButton() {
		getContinueButton().click();
	}
	
	// Functional

	// Business Logic
	@Step("@Step: continueValidatorMyAccountPage")
	public ValidatorMyAccountPage continueValidatorMyAccountPage() {
		clickContinueButton();
        return new ValidatorMyAccountPage(driver);
    }

}
