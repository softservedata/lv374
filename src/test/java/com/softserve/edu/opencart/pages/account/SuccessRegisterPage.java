package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessRegisterPage extends RightMenuUnit {

    public static final String EXPECTED_RESULT_SUCCESS_REGISTER_PAGE = "has been created";

    private WebElement continueButton;
    private WebElement successfulCreatedLable;

    SuccessRegisterPage(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements() {
        continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary"));
        successfulCreatedLable = driver.findElement(By.cssSelector("h1"));
    }

    // Page Object

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

    //successfulCreatedLable
    public WebElement getSuccessfulCreatedLable() {
        return successfulCreatedLable;
    }

    public String getSuccessfulCreatedLableText() {
        return getSuccessfulCreatedLable().getText();
    }

    // Functional

    // Business Logic
    public MyAccountPage continueMyAccountPage() {
        clickContinueButton();
        return new MyAccountPage(driver);
    }
}
