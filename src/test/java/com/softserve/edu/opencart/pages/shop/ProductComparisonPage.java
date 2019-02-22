package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.common.NavigationUnit;

public class ProductComparisonPage extends NavigationUnit {

	private ProductComparisonComponent productComparisonComponent;
	protected ProductComparisonPage(WebDriver driver) {
		super(driver);
		productComparisonComponent = new ProductComparisonComponent(driver);
	}
	public ProductComparisonComponent getProductComparisonComponent(){
        return productComparisonComponent;
	}
}