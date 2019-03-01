package com.softserve.edu.opencart.tests.melnyk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.WishListPage;

public class DeleteFromWishListTest extends TestRunner{
		
    public static final Logger logger = LoggerFactory.getLogger(AddToWishListTest.class);

	/**
	 * Provide valid user to log in and product that will be tested.
	 */
	@DataProvider
	public Object[][] dataProvider() {
		return new Object[][] { { UserRepository.getValid() ,
			 ProductRepository.getIPhone()
			 } };
	}
	
	/**
	 * Positive test
	 * Used Technique: State transition
	 * Check if delete button on wish list deleting product from wish list
	 * 
	 * @param validUser user that exist in database
	 * @param validProduct product that will be tested
	 */
	@Test(dataProvider = "dataProvider")
	public void checkDeleteFromWishList(IUser validUser, Product validProduct) {
				
        logger.info("START TEST: checkDeleteFromWishList");

		WishListPage wishListPage = loadApplication()
				.gotoLogin()
				.successLogin(validUser)
				.gotoHomePage()
	 			.successfulSearch(validProduct)
				.getSearchResultComponent()
				.getProductComponentsContainer()
				.addToWishList(validProduct)
				.gotoWishList()
				.deleteFromWishList(validProduct);
		
		Assert.assertTrue(wishListPage
				.checkEmptyWishList());
				
		logger.info("DONE TEST: checkDeleteFromWishList");
		}
	
}
