package com.softserve.edu.opencart.pages.shop;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductComparisonContainer{
	private static final String PRODUCT_COMPONENT_CSSSELECTOR  = "#content > table > tbody > tr> td";
	protected WebDriver driver;
    //
    private List<ProductComparisonComponent> productComponents;

    public ProductComparisonContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    private void initElements() {
    	productComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR))) {
        	productComponents.add(new ProductComparisonComponent(current));
        }
        System.out.println(productComponents);
    }
}