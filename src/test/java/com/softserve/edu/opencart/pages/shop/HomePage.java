package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.data.Product;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.common.HeadUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends HeadUnit {
	public static final String IPHONE_IMAGE = "iPhone6-1140x380.jpg";
	public static final Logger logger = LoggerFactory.getLogger(HomePage.class);

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

	/**
	 * Get all products which exist at the page
	 * @return
	 */
	public ProductComponentsContainer getProductComponentsContainer() {
		return productComponentsContainer;
	}

	// Functional

	/**
	 * Refresh page
	 * @return
	 */
	public HomePage refresh(){
		driver.navigate().refresh();
		return new HomePage(driver);
	}

	// Business Logic

	/**
	 * Change currency for USD, EURO or POUND STERLING
	 * @param currency
	 * @return
	 */
	@Step("Change Currency")
	public HomePage chooseCurrency(Currencies currency) {
        clickCurrencyByPartialName(currency);
        logger.info("Currency changed to "+currency);
        return new HomePage(driver); 
    }

	/**
	 * Get product and add it to Shopping Cart
	 * @param product
	 * @return
	 */
	@Step("Add product to Shopping Cart")
	public HomePage addToShoppingCart(Product product){
		getProductComponentsContainer().clickProductComponentAddToCartButtonByName(product.getName());
		logger.info("Product " + product.getName() + " is added to Shopping Cart");
		return new HomePage(driver);
	}
    public HomePage addToCompare(Product product) {
    	getProductComponentsContainer().clickProductComponentAddToCompareByName(product.getName());
		return new HomePage(driver);
	}


	/**
	 * Get currency symbol from product price
	 * @param product
	 * @return
	 */
	@Step("Get Currency symbol")
	public String getHomePageCurrencySymbol(Product product){
		return getProductComponentsContainer().getCurrencyByProduct(product);
	}
	}
