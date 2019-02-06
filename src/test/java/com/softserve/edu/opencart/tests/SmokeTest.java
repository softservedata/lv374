package com.softserve.edu.opencart.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;

public class SmokeTest extends TestRunner {

	@DataProvider//(parallel = true)
	public Object[][] productData() {
		return new Object[][] {
			{ ProductRepository.getMacBook() },
			{ ProductRepository.getIPhone() },
		};
	}
	
	@Test(dataProvider = "productData")
	public void checkSearch(Product validProduct) throws Exception {
		//loadApplication();
	}
	
}
