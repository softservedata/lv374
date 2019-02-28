package com.softserve.edu.opencart.pages.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.tools.PriceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Product;

public class ProductComponentsContainer {
	private static final String PRODUCT_COMPONENT_CSSSELECTOR = ".product-layout";

	protected WebDriver driver;
	//
	private List<ProductComponent> productComponents;
	
	public ProductComponentsContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		productComponents = new ArrayList<>();
		for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR))) {
			productComponents.add(new ProductComponent(current, driver));
		}
	}

	// Page Object
	
	// productComponents
	private List<ProductComponent> getProductComponents() {
		return productComponents;
	}

	// Functional
	
	// productComponents
	private ProductComponent getProductComponentByName(String productName) {
		ProductComponent result = null;
		for (ProductComponent current : getProductComponents()) {
			if (current.getNameText().toLowerCase()
					.equals(productName.toLowerCase())) {
				result = current;
			}
		}
		if (result == null) {
			// TODO Develop Custom Exception 
			throw new RuntimeException("ProductName: " + productName + " not Found.");
		}
		return result;
	}
	
	private BigDecimal getProductComponentPriceByName(String productName) {
		return PriceUtils.getPrice(getProductComponentByName(productName).getPriceText());
	}

	private String getProductComponentDescriptionByName(String productName) {
		return getProductComponentByName(productName).getPartialDescriptionText();
	}

	public void clickProductComponentAddToCartButtonByName(String productName) {
		getProductComponentByName(productName).clickAddToCartButton();
	}

	private void clickProductComponentAddToWishButtonByName(String productName) {
		getProductComponentByName(productName).clickAddToWishButton();
	}

	public String getCurrencyByProduct(Product product){
		return PriceUtils.getCurrencySymbol(getProductComponentByName(product.getName()).getPriceText());
	}

	// Business Logic

	public BigDecimal getProductComponentPriceByProduct(Product product) {
		return getProductComponentPriceByName(product.getName());
	}

	public String getProductComponentDescriptionByProduct(Product product) {
		return getProductComponentDescriptionByName(product.getName());
	}

	public HomePage addToWishList(Product product) {
		clickProductComponentAddToWishButtonByName(product.getName());
		return new HomePage(driver);
	}
	
}
