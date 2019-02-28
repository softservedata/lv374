package com.softserve.edu.opencart.pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishListComponent {
	
    WebElement wishlistSketch;
    private final static int productNameTd = 2;
    private final static int productActionTd = 6;
    
    private WishListContainer wishListContainer;
    
    protected WishListComponent(WebElement wishlistSketch) {
    	this.wishlistSketch = wishlistSketch;
    }
    
   //Page Object
    
   //wishListContainer
    public WishListContainer getWishListContainer() {
    	return wishListContainer;
    }
    
   //wishlistSketch
   public WebElement getWishListSketch() {
	   return wishlistSketch;
   }
   
   //wishlistProductName
   public WebElement getWishListProductName() {
	   return wishlistSketch.findElement(By.cssSelector("td:nth-child(" + productNameTd +")>a"));
   }

    public WebElement getWishlistUnitPrice(){
        return wishlistSketch.findElement(By.cssSelector(".price"));
    }
   
   public String getWishListProductNameText() {
	   return getWishListProductName().getText();
   }

   public String getWishlistUnitPriceText(){
        return getWishlistUnitPrice().getText().trim();
   }
   
   //addToCartButton
   public WebElement getAddToCartButton() {
	   return wishlistSketch.findElement(By.cssSelector("td:nth-child(" + productActionTd + ")>button"));
   }
   
   public void clickAddToCartButton() {
	   getAddToCartButton().click();;
   }
   
   //deleteButton
   public WebElement getDeleteButton() {
	   return wishlistSketch.findElement(By.cssSelector("td:nth-child(" + productActionTd + ")>a"));
   }
   
   public void clickDeleteButton() {
	   getDeleteButton().click();
   }
   
   
   
}
