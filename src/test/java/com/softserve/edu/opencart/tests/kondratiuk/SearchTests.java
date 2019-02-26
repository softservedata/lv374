package com.softserve.edu.opencart.tests.kondratiuk;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.shop.HomePage;
import com.softserve.edu.opencart.pages.shop.SuccessfulSearchPage;
import com.softserve.edu.opencart.pages.shop.UnsuccessfulSearchPage;

public class SearchTests extends TestRunner {

	@DataProvider(name = "DataSet1")
	public Object[][] DataSet1() {
		return new Object[][] {
			{ ProductRepository.getIPhone(),
				}
		};
	}
	
	@Test(dataProvider = "DataSet1")
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
	@DataProvider(name = "DataSet2")
	public Object[][] DataSet2() {
		return new Object[][] {
			{ ProductRepository.getInvalidProduct(),
				}
			
			};
		}
	@Test(dataProvider = "DataSet2")
	public void errorCheck (Product invalidProduct) throws Exception {
		UnsuccessfulSearchPage unsuccessfulSearchPage = loadApplication()
				.unsuccessfulSearch(invalidProduct);
		Assert.assertTrue(unsuccessfulSearchPage.getNoProductLabelText().contains("There is no product that matches the search criteria"));
	}
}