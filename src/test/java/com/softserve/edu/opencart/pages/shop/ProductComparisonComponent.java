package com.softserve.edu.opencart.pages.shop;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductComparisonComponent{
	WebElement driver;
	protected ProductComparisonComponent(WebDriver driver) {
    	this.driver = (WebElement) driver;
	}
	
	public WebElement driver() {
		   return driver;
	}
	
	 // RemoveButton;
	public WebElement getRemoveButton() {
		return driver.findElement(By.xpath("//*[@id='content']/table/tbody[3]/tr/td[2]/a"));
	}
	
    public void clickRemoveButton() {
    	getRemoveButton().click();
    }
	
    // ContinueButton;
	public WebElement getContinueButton() {
		return driver.findElement(By.xpath("//*[@id='content']/table/tbody[3]/tr/td[2]/a"));
	}
	
	public void clickContinueButtonn() {
    	getContinueButton().click();
    }
	
	// addToCartButton;
	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id='content']/table/tbody[2]/tr/td[2]/input"));
	}
	
	public void clickAddToCartButton() {
    	getAddToCartButton().click();
    }
	
	// product name
	public WebElement getProductName() {
		return driver.findElement(By.xpath("//*[@id='content']/table/tbody[1]/tr[1]/td[2]/a/strong"));
	}
	
	public String getProductNameText() {
		return getProductName().getText();
	}
	
	public void clicProductName() {
		getProductName().click();
    }
	
    // price;
    public WebElement getPrice() {
        return driver.findElement(By.xpath("//*[@id='content']/table/tbody[1]/tr[3]/td[2]"));
    }

    public String getPriceText() {
        return getPrice().getText();
    }
    
    // Success Message
 	public WebElement getSuccessMessage() {
 		return driver.findElement(By.xpath("/html/body/div[2]/div[1]"));
 	}
 	public String getSuccessMessageText() {
 		return getSuccessMessage().getText();
 	}
}
