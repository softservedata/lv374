package com.softserve.edu.opencart.tests.kondratiuk;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.shop.UnsuccessfulSearchPage;

public class UnsuccesSearch extends TestRunner {
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{ 
				ProductRepository.getInvalidProduct(), }
		};
	}
	@Test(dataProvider = "productData")
	public void errorCheck (Product invalidProduct) throws Exception {
		UnsuccessfulSearchPage unsuccessfulSearchPage = loadApplication()
				.unsuccessfulSearch(invalidProduct);
		Assert.assertTrue(unsuccessfulSearchPage.getNoProductLabelText().contains("There is no product that matches the search criteria"));
	}
}
