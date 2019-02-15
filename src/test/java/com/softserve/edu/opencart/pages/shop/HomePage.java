package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.common.HeadUnit;

public class HomePage extends HeadUnit {
	public static final String IPHONE_IMAGE = "iPhone6-1140x380.jpg";
	
	private WebElement slideshow0;
	//
	private ProductComponentsContainer productComponentsContainer;
	
	public HomePage(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private void initElements() {
		//slideshow0 = driver.findElement(By.id("slideshow0"));
		slideshow0 = driver.findElement(By.cssSelector("#slideshow0"));
		//
		productComponentsContainer = new ProductComponentsContainer(driver);
	}

	// Page Object

	// slideshow0
	public WebElement getSlideshow0() {
		return slideshow0;
	}

	// slideshow0FirstImage
	public WebElement getSlideshow0FirstImage() {
		//return getSlideshow0().findElement(By.cssSelector("a > img"));
		return getSlideshow0().findElement(By.xpath(".//a/img"));
		//return getSlideshow0().findElement(By.xpath("//a/img")); // ERROR
		//return driver.findElement(By.xpath("//div[@id='slideshow0']//a/img"));
	}

	public String getSlideshow0FirstImageAttributeText(String attribute) {
		return getSlideshow0FirstImage().getAttribute(attribute).trim();
	}

	public String getSlideshow0FirstImageAttributeSrcText() {
		System.out.println("Attribute: " + getSlideshow0FirstImageAttributeText(TAG_ATTRIBUTE_SRC));
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

}
