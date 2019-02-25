package com.softserve.edu.opencart.tests.kondratiuk;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.shop.HomePage;
import com.softserve.edu.opencart.pages.shop.SuccessfulSearchPage;

public class SearchTests extends TestRunner {

	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{ ProductRepository.getIPhone(),
				}
		};
	}
	
	@Test(dataProvider = "productData")
	public void checkSearch(Product validProduct) throws Exception {
		// Steps
		SuccessfulSearchPage successfulSearchPage = loadApplication()
				.successfulSearch(validProduct);
		// Check
		Assert.assertEquals(successfulSearchPage
				.getProductComponentPrice(validProduct)
				,validProduct.getPriceDollar());
		Assert.assertTrue(successfulSearchPage
				.getProductComponentDescription(validProduct)
				.contains(validProduct.getDescription()));
		// Steps
		HomePage homePage = successfulSearchPage
				.gotoHomePage();
		// Check
		Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.IPHONE_IMAGE));
	}
}