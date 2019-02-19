package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopingCartProductComponent {

    WebElement productSketch;

    protected ShopingCartProductComponent(WebElement productSketch){
        this.productSketch = productSketch;
    }

    //productSketch
    public WebElement getProductSketch(){return productSketch;}

    //productName
    public WebElement getProductName(){
        return productSketch.findElement(By.cssSelector("td:nth-child(2)>a"));
    }

    public String getProductNameText(){
        return getProductName().getText();
    }

    public void clickProductName(){
        getProductName().click();
    }

    //productModel
    public WebElement getProductModel(){
        return productSketch.findElement(By.cssSelector("td:nth-child(3)"));
    }

    public String getProductModelText(){
        return getProductModel().getText();
    }

    //quantity
    public WebElement getQuantityField(){
        return productSketch.findElement(By.cssSelector("input"));
    }

    public void clearQuantityField(){
        getQuantityField().clear();
    }

    public void clickQuantityField(){
        getQuantityField().click();
    }

    public WebElement getUpdateQuantityButton(){
        return productSketch.findElement(By.cssSelector("button[data-original-title='Update']"));
    }

    public void clickUpdateQuantityButton(){
        getUpdateQuantityButton().click();
    }

    public WebElement getRemoveFromShoppingCartButton(){
        return productSketch.findElement(By.cssSelector("button[data-original-title='Remove']"));
    }

    public void clickRemoveFromShoppingCartButton(){
        getRemoveFromShoppingCartButton().click();
    }

    //unitPrice
    public WebElement getUnitPrice(){
        return productSketch.findElement(By.cssSelector("td:nth-child(5)"));
    }

    public String getUnitPriceText(){
        return getUnitPrice().getText();
    }

    //totalPrice
    public WebElement getTotalPrice(){
        return productSketch.findElement(By.cssSelector("td:nth-child(6)"));
    }

    public String getTotalPriceText(){
        return getUnitPrice().getText();
    }

    // Functional

    public void setQuantity(String quantity){
        clickQuantityField();
        clearQuantityField();
        getQuantityField().sendKeys(quantity);
        clickUpdateQuantityButton();
    }

    // Business Logic

}
