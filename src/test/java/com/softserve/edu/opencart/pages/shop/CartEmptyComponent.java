package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.softserve.edu.opencart.pages.common.HeadUnit;

public class CartEmptyComponent extends HeadUnit {
	public CartEmptyComponent(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = ".//p[@class='text-center']")
	private WebElement cartEmpty;

	public String getCartEmptyText() {
		return cartEmpty.getText();
	}
}
