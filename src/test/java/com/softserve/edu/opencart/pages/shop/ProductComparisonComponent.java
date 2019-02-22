package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ProductComparisonComponent extends ProductComparisonPage {
	private WebElement removeButton;
	private WebElement continueButton;
	private WebElement addToCartButton;
	private WebElement successMessage;
	private WebElement productName;
	private WebElement productPrice;
	
	
	public ProductComparisonComponent(WebDriver driver) {
		super(driver);
		initElements();
	}
	private void initElements() {
		removeButton = driver.findElement(By.xpath("//*[@id='content']/table/tbody[3]/tr/td[2]/a"));
		continueButton = driver.findElement(By.xpath("//*[@id='content']/table/tbody[3]/tr/td[2]/a"));
		addToCartButton = driver.findElement(By.xpath("//*[@id='content']/table/tbody[2]/tr/td[2]/input"));
		productName = driver.findElement(By.xpath("//*[@id='content']/table/tbody[1]/tr[1]/td[2]/a/strong"));
		productPrice = driver.findElement(By.xpath("//*[@id='content']/table/tbody[1]/tr[3]/td[2]"));
		successMessage = driver.findElement(By.xpath("/html/body/div[2]/div[1]"));
	}
	public WebElement getremoveButton() {
		return removeButton;
	}
	public WebElement getcontinueButton() {
		return continueButton;
	}
	public WebElement getaddToCartButton() {
		return addToCartButton;
	}
	
	// product name
	public WebElement getProductName() {
		return productName;
	}
	public String getProductNameText() {
		return getProductName().getText();
	}
	public void clicProductName() {
		getProductName().click();
    }
    // price;
    public WebElement getPrice() {
        return productPrice;
    }

    public String getPriceText() {
        return getPrice().getText();
    }
    
    // RemoveButton;
    public WebElement getRemoveButton() {
        return removeButton;
    }
    
    public void clickRemoveButton() {
    	getRemoveButton().click();
    }
    
    // ContinueButton;
    public WebElement getContinueButton() {
        return continueButton;
    }
    
    public void clickContinueButtonn() {
    	getContinueButton().click();
    }
    // addToCartButton;
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
    
    public void clickAddToCartButton() {
    	getAddToCartButton().click();
    }
 // Success Message
 	public WebElement getSuccessMessage() {
 		return successMessage;
 	}
 	public String getSuccessMessageText() {
 		return getSuccessMessage().getText();
 	}
}
