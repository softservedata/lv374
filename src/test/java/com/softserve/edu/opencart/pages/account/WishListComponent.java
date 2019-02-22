package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishListComponent {
	
    WebElement wishlistSketch;

    protected WishListComponent(WebElement wishlistSketch) {
    	this.wishlistSketch = wishlistSketch;
    }
    
   //Page Object
    
   //wishlistSketch
   public WebElement getWishListSketch() {
	   return wishlistSketch;
   }
   
   //wishlistProductName
   public WebElement getWishListProductName() {
	   return wishlistSketch.findElement(By.cssSelector("td:nth-child(2)>a"));
   }
   
   public String getWishListProductNameText() {
	   return getWishListProductName().getText();
   }
   
   //addToCartButton
   public WebElement getAddToCartButton() {
	   return wishlistSketch.findElement(By.cssSelector("td:nth-child(6)>button"));
   }
   
   public void clickAddToCartButton() {
	   getAddToCartButton().click();
   }
   
   //deleteButton
   public WebElement getDeleteButton() {
	   return wishlistSketch.findElement(By.cssSelector("td:nth-child(6)>a"));
   }
   
   public void clickDeleteButton() {
	   getDeleteButton().click();
   }
   
   
   
}
