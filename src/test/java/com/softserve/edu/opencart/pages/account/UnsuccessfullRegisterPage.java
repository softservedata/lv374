package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.*;

public class UnsuccessfullRegisterPage extends RegisterPage {

    public static final String EXPECTED_WARNING_EMAIL = "E-Mail Address does not appear to be valid!";
    public static final String EXPECTED_WARNING_BAD_EMAIL = "@";
    public static final String EXPECTED_WARNING_FIRST_NAME = "First Name must be between 1 and 32 characters!";
    public static final String EXPECTED_WARNING_LAST_NAME = "Last Name must be between 1 and 32 characters!";
    public static final String EXPECTED_WARNING_FIRST_NAME_DIGITS = "First Name cannot contain digits";

    public UnsuccessfullRegisterPage(WebDriver driver) {
        super(driver);
        checkElements();
    }
    private void checkElements() {
        getTextDanger();
    }

    // Page Object

    //textDanger
    public WebElement getTextDanger() {
        return driver.findElement(By.cssSelector(".text-danger"));
    }

    public String getTextDangerText() {
        return getTextDanger().getText();
    }

//    alertEmail
//    public String getAlertEmailText(){
//        Alert emailAlert = driver.switchTo().alert();
//        String alertEmailText = emailAlert.getText();
//        return alertEmailText;
//    }
//
//    public WebElement getEmailAlert() {
//        return driver.findElement(By.className(".tooltip"));
//    }
//
//    public String getEmailAlertText() {
//        return getEmailAlert().getText();
//    }
//
//    public WebElement getToolTip(){
//        return driver.findElement(By.cssSelector("#input-email"));
//    }
//
//    public String getToolTipText(){
//       return getToolTip().getAttribute("title");
//    }

    // Functional

    // Business Logic

}
