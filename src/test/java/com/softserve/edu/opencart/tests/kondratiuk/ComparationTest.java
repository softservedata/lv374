package com.softserve.edu.opencart.tests.kondratiuk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.WishListPage;
import com.softserve.edu.opencart.pages.shop.HomePage;
import com.softserve.edu.opencart.pages.shop.ProductComparisonPage;
import com.softserve.edu.opencart.pages.shop.SuccessfulSearchPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComparationTest extends TestRunner {
	@DataProvider(name = "Dataset1")
	public Object[][] Dataset1() {
		return new Object[][] {
			{ ProductRepository.getIPhone(),
				}
		};
	}
	
	@Test (dataProvider = "Dataset1")
	public void comparationCheck(Product validProduct) throws Exception {
		ProductComparisonPage productComparisonPage = loadApplication()
			.successfulSearch(validProduct)
			.getSearchResultComponent()
			.getProductComponentsContainer()
			.addToCompare(validProduct)
			.gotocompare();
		Assert.assertTrue(productComparisonPage
				.getProductComparisonComponent()
				.getProductNameText(validProduct)
				.contains(validProduct.getName()));
			
}
	@Test (dataProvider = "Dataset1")
	public void comparationDeleteCheck(Product validProduct) throws Exception {
		ProductComparisonPage productComparisonPage = loadApplication()
			.successfulSearch(validProduct)
			.getSearchResultComponent()
			.getProductComponentsContainer()
			.addToCompare(validProduct)
			.gotocompare()
			.removeFromComparison();
		Assert.assertTrue(productComparisonPage
				.getProductComparisonComponent()
				.getSuccessMessageText().contains("You have not chosen any products to compare."));
	}
}