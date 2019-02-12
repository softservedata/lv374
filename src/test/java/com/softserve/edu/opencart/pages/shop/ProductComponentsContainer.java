package com.softserve.edu.opencart.pages.shop;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Product;

public class ProductComponentsContainer {
	private static final String PRODUCT_COMPONENT_CSSSELECTOR = ".product-layout";

	private WebDriver driver;
	//
	private List<ProductComponent> productComponents;
	
	public ProductComponentsContainer(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		productComponents = new ArrayList<>();
		for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR))) {
			productComponents.add(new ProductComponent(current));
		}
	}

	// Page Object
	
	// productComponents
	public List<ProductComponent> getProductComponents() {
		return productComponents;
	}

	// Functional
	
	// productComponents
	public ProductComponent getProductComponentByName(String productName) {
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
	
	public String getProductComponentPriceByName(String productName) {
		return getProductComponentByName(productName).getPriceText();
	}

	public String getProductComponentDescriptionByName(String productName) {
		return getProductComponentByName(productName).getPartialDescriptionText();
	}

	public void clickProductComponentAddToCartButtonByName(String productName) {
		getProductComponentByName(productName).clickAddToCartButton();
	}

	public void clickProductComponentAddToWishButtonByName(String productName) {
		getProductComponentByName(productName).clickAddToWishButton();
	}

	// Business Logic

	public String getProductComponentPriceByProduct(Product product) {
		return getProductComponentPriceByName(product.getName());
	}

	public String getProductComponentDescriptionByProduct(Product product) {
		return getProductComponentDescriptionByName(product.getName());
	}

}
