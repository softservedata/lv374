package com.softserve.edu.opencart.pages.account;

import com.softserve.edu.opencart.pages.shop.SuccessfulSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends RightLogoutUnit {

//    private WebElement firstNameInput;
//    private WebElement lastNameInput;
//    private WebElement emailInput;
//    private WebElement telephoneInput;
//    private WebElement faxInput;
//    private WebElement companyInput;
//    private WebElement address1Input;
//    private WebElement address2Input;
//    private WebElement cityInput;
//    private WebElement postCodeInput;
//    //country TODO
//    //region TODO
//    private WebElement passwordInput;
//    private WebElement passwordConfirmInput;
//    private WebElement privacyPolicyCheckBox;
//    private WebElement confirmButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        //initElements();
        checkElements();
    }

//    private void initElements(){
//        firstNameInput = driver.findElement(By.cssSelector("#input-firstname"));
//        lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
//        emailInput = driver.findElement(By.cssSelector("#input-email"));
//        telephoneInput = driver.findElement(By.cssSelector("#input-telephone"));
//        faxInput = driver.findElement(By.cssSelector("#input-fax"));
//        companyInput = driver.findElement(By.cssSelector("#input-company"));
//        address1Input = driver.findElement(By.cssSelector("#input-address-1"));
//        address2Input = driver.findElement(By.cssSelector("#input-address-2"));
//        cityInput = driver.findElement(By.cssSelector("#input-city"));
//        postCodeInput = driver.findElement(By.cssSelector("#input-postcode"));
//        passwordInput = driver.findElement(By.cssSelector("#input-password"));
//        passwordConfirmInput = driver.findElement(By.cssSelector("#input-confirm"));
//        privacyPolicyCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
//        confirmButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
//    }
    private void checkElements(){
        getFirstNameInput();
        getLastNameInput();
        getEmailInput();
        getTelephoneInput();
        getFaxInput();
        getCompanyInput();
        getAddress1Input();
        getAddress2Input();
        getCityInput();
        getPostCodeInput();
        getPasswordInput();
        getPasswordConfirmInput();

    }
    //Page Object

    //firstNameInput
    public WebElement getFirstNameInput(){
        //return firstNameInput;
        return driver.findElement(By.cssSelector("#input-firstname"));
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
        //return lastNameInput;
        return driver.findElement(By.cssSelector("#input-lastname"));
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
        //return emailInput;
        return driver.findElement(By.cssSelector("#input-email"));
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
        //return telephoneInput;
        return driver.findElement(By.cssSelector("#input-telephone"));
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
        //return faxInput;
        return driver.findElement(By.cssSelector("#input-fax"));
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
        //return companyInput;
        return driver.findElement(By.cssSelector("#input-company"));
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
        //return address1Input;
        return driver.findElement(By.cssSelector("#input-address-1"));
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
        //return address2Input;
        return driver.findElement(By.cssSelector("#input-address-2"));
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
        //return cityInput;
        return driver.findElement(By.cssSelector("#input-city"));
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
        //return postCodeInput;
        return driver.findElement(By.cssSelector("#input-postcode"));
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
        //return passwordInput;
        return driver.findElement(By.cssSelector("#input-password"));
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
        //return passwordConfirmInput;
        return driver.findElement(By.cssSelector("#input-confirm"));
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
        //return privacyPolicyCheckBox;
        return driver.findElement(By.xpath("//input[@type='checkbox']"));
    }

    public void clickPrivacyPolicyCheckBox(){
        getPrivacyPolicyCheckBox().click();
    }

    //confirmButton
    public WebElement getConfirmButton(){
        //return confirmButton;
        return driver.findElement(By.cssSelector(".btn.btn-primary"));
    }

    public void clickConfirmButton(){
        getConfirmButton().click();
    }

    //Functional
    public void registerUser(){

    }

    //Business Logic
//    public SuccessRegisterPage successRegisterPage(){
//        return SuccessRegisterPage;
//    }
}

