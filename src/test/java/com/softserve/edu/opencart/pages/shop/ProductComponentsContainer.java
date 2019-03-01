package com.softserve.edu.opencart.pages.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.tools.PriceUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductComponentsContainer {

	public static final Logger logger = LoggerFactory.getLogger(ProductComponentsContainer.class);

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
	public void clickProductComponentAddToCompareByName(String productName) {
		getProductComponentByName(productName).clickAddToCompareButton();
	}

	/**
	 * Get currency symbol from product price
	 * @param product
	 * @return
	 */
	public String getCurrencyByProduct(Product product){
		return PriceUtils.getCurrencySymbol(getProductComponentByName(product.getName()).getPriceText());
	}

	// Business Logic

	/**
	 * Get product price
	 * @param product product which price you need to get
	 * @return
	 */
	@Step("Get Product price")
	public BigDecimal getProductComponentPriceByProduct(Product product) {
		logger.info("Product "+product.getName()+" cost "+getProductComponentPriceByName(product.getName()));
		return getProductComponentPriceByName(product.getName());
	}

	/**
	 * Gte product description
	 * @param product product which description you need to get
	 * @return
	 */
	public String getProductComponentDescriptionByProduct(Product product) {
		return getProductComponentDescriptionByName(product.getName());
	}

	/**
	 * Add product to wish list
	 * @param product
	 * @return
	 */
	@Step("Add to Wish List")
	public HomePage addToWishList(Product product) {
		clickProductComponentAddToWishButtonByName(product.getName());
		return new HomePage(driver);
	}
	public SuccessfulSearchPage addToCompare(Product product) {
    	clickProductComponentAddToCompareByName(product.getName());
		return new SuccessfulSearchPage(driver);
	}
}