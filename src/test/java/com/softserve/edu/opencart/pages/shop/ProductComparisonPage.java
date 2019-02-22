package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.common.NavigationUnit;

public class ProductComparisonPage extends NavigationUnit {

	private ProductComparisonContainer productComparisonContainer;
	protected ProductComparisonPage(WebDriver driver) {
		super(driver);
		productComparisonContainer = new ProductComparisonContainer(driver);
	}
	public ProductComparisonContainer getProductComparisonContainer(){
        return productComparisonContainer;
	}
}