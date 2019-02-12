package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends RightLogoutUnit {

    private WebElement firstNameInput;
    private WebElement lastNameInput;
    private WebElement emailInput;
    private WebElement telephoneInput;
    private WebElement faxInput;
    private WebElement companyInput;
    private WebElement address1Input;
    private WebElement address2Input;
    private WebElement cityInput;
    private WebElement postCodeInput;
    //country TODO
    //region TODO
    private WebElement passwordInput;
    private WebElement passwordConfirmInput;
    private WebElement privacyPolicyCheckBox;
    private WebElement confirmButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        firstNameInput = driver.findElement(By.cssSelector("#input-firstname"));
        lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        emailInput = driver.findElement(By.cssSelector("#input-email"));
        telephoneInput = driver.findElement(By.cssSelector("#input-telephone"));
        faxInput = driver.findElement(By.cssSelector("#input-fax"));
        companyInput = driver.findElement(By.cssSelector("#input-company"));
        address1Input = driver.findElement(By.cssSelector("#input-address-1"));
        address2Input = driver.findElement(By.cssSelector("#input-address-2"));
        cityInput = driver.findElement(By.cssSelector("#input-city"));
        postCodeInput = driver.findElement(By.cssSelector("#input-postcode"));
        passwordInput = driver.findElement(By.cssSelector("#input-password"));
        passwordConfirmInput = driver.findElement(By.cssSelector("#input-confirm"));
        privacyPolicyCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        confirmButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
    }
    //Page Object

    //firstNameInput
    public WebElement getFirstNameInput(){
        return firstNameInput;
    }

    public void clickFistNameInput(){
        getFirstNameInput().click();
    }

    public void clearFirstNameField(){
        getFirstNameInput().clear();
    }

    public void setFirstNameInput(String validFirstName){
        getFirstNameInput().sendKeys(validFirstName);
    }

    //lastNameInput
    public WebElement getLastNameInput(){
        return lastNameInput;
    }

    public void clickLastNameInput(){
        getLastNameInput().click();
    }

    public void clearLastNameField(){
        getLastNameInput().clear();
    }

    public void setLastNameInput(String validLastName){
        getLastNameInput().sendKeys(validLastName);
    }

    //emailInput
    public WebElement getEmailInput(){
        return emailInput;
    }

    public void clickEmailInput(){
        getEmailInput().click();
    }

    public void clearEmailInput(){
        getEmailInput().clear();
    }

    public void setEmailInput(String validEmail){
        getEmailInput().sendKeys(validEmail);
    }

    //telephoneInput
    public WebElement getTelephoneInput(){
        return telephoneInput;
    }

    public void clickTelephoneInput(){
        getTelephoneInput().click();
    }

    public void clearTelephoneInput(){
        getTelephoneInput().clear();
    }

    public void setTelephoneInput(String validTelephone){
        getTelephoneInput().sendKeys(validTelephone);
    }

    //faxInput
    public WebElement getFaxInput(){
        return faxInput;
    }

    public void clickFaxInput(){
        getFaxInput().click();
    }

    public void clearFaxInput(){
        getFaxInput().clear();
    }

    public void setFaxInput(String validFax){
        getFaxInput().sendKeys(validFax);
    }

    //companyInput
    public WebElement getCompanyInput(){
        return companyInput;
    }

    public void clickCompanyInput(){
        getCompanyInput().click();
    }

    public void clearCompanyInput(){
        getCompanyInput().clear();
    }

    public void setCompanyInput(String validCompany){
        getCompanyInput().sendKeys();
    }

    //address1Input
    public WebElement getAddress1Input(){
        return address1Input;
    }

    public void clickAddress1Input(){
        getAddress1Input().click();
    }
    public void clearAddress1Input(){
        getAddress1Input().clear();
    }

    public void setAddress1Input(String validAddress1Input){
        getAddress1Input().sendKeys(validAddress1Input);
    }

    //address2Input
    public WebElement getAddress2Input(){
        return address2Input;
    }

    public void clickAddress2Input(){
        getAddress2Input().click();
    }
    public void clearAddress2Input(){
        getAddress2Input().clear();
    }

    public void setAddress2Input(String validAddress2Input){
        getAddress2Input().sendKeys(validAddress2Input);
    }

    //cityInput
    public WebElement getCityInput(){
        return cityInput;
    }

    public void clickCityInput(){
        getCityInput().click();
    }

    public void clearCityInput(){
        getCityInput().clear();
    }

    public void setCityInput(String validCity){
        getCityInput().sendKeys(validCity);
    }

    //postCodeInput
    public WebElement getPostCodeInput(){
        return postCodeInput;
    }

    public void clickPostCodeInput(){
        getPostCodeInput().click();
    }

    public void clearPostCodeInput(){
        getPostCodeInput().clear();
    }

    public void setPostCodeInput(String validPostCode) {
        getPostCodeInput().sendKeys();
    }

    //passwordInput
    public WebElement getPasswordInput(){
        return passwordInput;
    }

    public void clickPasswordInput(){
        getPasswordInput().click();
    }

    public void clearPasswordInput(){
        getPasswordInput().clear();
    }

    public void setPasswordInput(String validPassword){
        getPasswordInput().sendKeys(validPassword);
    }

    //passwordConfirmInput
    public WebElement getPasswordConfirmInput(){
        return passwordConfirmInput;
    }

    public void clickPasswordConfirmInput(){
        getPasswordConfirmInput().click();
    }

    public void clearPasswordConfirmInput(){
        getPasswordConfirmInput().clear();
    }

    public void setPasswordConfirmInput(String validConfirmPassword){
        getPasswordConfirmInput().sendKeys(validConfirmPassword);
    }

    //privacyPolicyCheckBox
    public WebElement getPrivacyPolicyCheckBox(){
        return privacyPolicyCheckBox;
    }

    public void clickPrivacyPolicyCheckBox(){
        getPrivacyPolicyCheckBox().click();
    }

    //confirmButton
    public WebElement getConfirmButton(){
        return confirmButton;
    }

    public void clickConfirmButton(){
        getConfirmButton().click();
    }
}

