package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.common.HeadUnit;

public class HomePage extends HeadUnit {
	public static final String IPHONE_IMAGE = "iPhone6-1140x380.jpg";

	//
	private ProductComponentsContainer productComponentsContainer;
	
	public HomePage(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private void initElements() {
		//
		productComponentsContainer = new ProductComponentsContainer(driver);
	}

	// Page Object

	// slideshow0
	private WebElement getSlideshow0() {
		return driver.findElement(By.cssSelector("#slideshow0"));
	}
	
	// slideshow0FirstImage
	private WebElement getSlideshow0FirstImage() {
		return getSlideshow0().findElement(By.xpath(".//a/img"));
	}

	private String getSlideshow0FirstImageAttributeText(String attribute) {
		return getSlideshow0FirstImage().getAttribute(attribute).trim();
	}

	public String getSlideshow0FirstImageAttributeSrcText() {
		return getSlideshow0FirstImageAttributeText(TAG_ATTRIBUTE_SRC);
	}

	// productComponentsContainer
	public ProductComponentsContainer getProductComponentsContainer() {
		return productComponentsContainer;
	}

	// Functional

	// Business Logic
	
	public HomePage chooseCurrency(Currencies currency) {
        clickCurrencyByPartialName(currency);
        return new HomePage(driver); 
    }

    public HomePage addToShoppingCart(Product product){
		getProductComponentsContainer().clickProductComponentAddToCartButtonByName(product.getName());
		return new HomePage(driver);
	}

	public String getHomePageCurrencySymbol(Product product){
		return getProductComponentsContainer().getCurrencyByProduct(product);
	}

}
