package com.softserve.edu.opencart.tools;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.common.NavigationUnit;
import com.softserve.edu.opencart.pages.shop.ShoppingCartProductsContainer;

public class ProductComparisonPage extends NavigationUnit {

	private ProductComparisonComponent productComparisonComponent;
	public ProductComparisonPage(WebDriver driver) {
		super(driver);
		productComparisonComponent = new ProductComparisonComponent(driver);
	}
	public ProductComparisonComponent getProductComparisonComponent(){
        return productComparisonComponent;
	}
}