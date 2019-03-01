package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.common.NavigationUnit;

public class ProductComparisonPage extends NavigationUnit {
	private ProductComparisonComponent productComparisonComponent;
    public ProductComparisonPage(WebDriver driver) {
        super(driver);
        productComparisonComponent = new ProductComparisonComponent(driver);
    }

	public ProductComparisonComponent getProductComparisonComponent() {
		return productComparisonComponent;
	}

	public ProductComparisonPage removeFromComparison() {
		getProductComparisonComponent().getRemoveButton().click();
		return new ProductComparisonPage(driver);
	}
	}
   