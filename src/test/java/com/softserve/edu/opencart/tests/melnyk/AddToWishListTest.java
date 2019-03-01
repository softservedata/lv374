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
import com.softserve.edu.opencart.pages.account.AccountLogoutPage;
import com.softserve.edu.opencart.pages.account.WishListPage;

public class AddToWishListTest extends TestRunner {

    public static final Logger logger = LoggerFactory.getLogger(AddToWishListTest.class);
	
	/**
	 * Provide valid user to log in and product that will be tested.
	 */
	@DataProvider
	public Object[][] oneProductDataProvider() {
		return new Object[][] { { UserRepository.getValid() ,
				ProductRepository.getIPhone()
		} };
	}

	/**
	 * Positive test
	 * Used technique: State transition
	 * Check if product added to wish list and if correct product added
	 * 
	 * @param validUser user that exist in database
	 * @param validProduct product that will be tested
	 */
	@Test(dataProvider = "oneProductDataProvider")
	public void addToWishListOneProduct(IUser validUser, Product validProduct) {
		
        logger.info("START TEST: addToWishListOneProduct");

		WishListPage wishListPage = loadApplication()
				.gotoLogin()
				.successLogin(validUser)
				.gotoHomePage()
	 			.successfulSearch(validProduct)
				.getSearchResultComponent()
				.getProductComponentsContainer()
				.addToWishList(validProduct)
				.gotoWishList();
		
		Assert.assertTrue(wishListPage
				.getWishListContainer()
				.getWishListProductByName(validProduct)
				.contains(validProduct.getName()));
		
		WishListPage cleanUpWishList = wishListPage
				.gotoWishList()
				.deleteFromWishList(validProduct);
		
		Assert.assertTrue(cleanUpWishList
				.checkEmptyWishList());
		
		AccountLogoutPage logout= cleanUpWishList
					.gotoLogout();
		Assert.assertTrue(logout.getAccountLogoutLabel().isDisplayed());
		
        logger.info("DONE TEST: addToWishListOneProduct");
	}

	/**
	 * Provide valid user to log in and products that will be tested.
	 */
	@DataProvider
	public Object[][] fewProductDataProvider() {
		return new Object[][] { { UserRepository.getValid() ,
				ProductRepository.getIPhone(),
				ProductRepository.getMacBook()
		} };
	}
	
	/**
	 * Positive test
	 * Used technique: State transition
	 * Check if few products added to wish list and if correct products added
	 * 
	 * @param validUser user that exist in database
	 * @param iPhone product that will be tested
	 * @param macBook product that will be tested
	 */
	@Test(dataProvider = "fewProductDataProvider")
	public void addToWishListFewProducts(IUser validUser, Product iPhone, Product macBook) {
		
        logger.info("START TEST: addToWishListFewProducts");
		
		WishListPage wishListPage = loadApplication()
				.gotoLogin()
				.successLogin(validUser)
				.gotoHomePage()
	 			.successfulSearch(iPhone)
				.getSearchResultComponent()
				.getProductComponentsContainer()
				.addToWishList(iPhone)
				.gotoHomePage()
				.successfulSearch(macBook)
				.getSearchResultComponent()
				.getProductComponentsContainer()
				.addToWishList(macBook)
				.gotoWishList();
		
		Assert.assertTrue(wishListPage
				.getWishListContainer()
				.getWishListProductByName(iPhone)
				.contains(iPhone.getName()) &&
				wishListPage
				.getWishListContainer()
				.getWishListProductByName(macBook)
				.contains(macBook.getName()));
		
		WishListPage cleanUpWishList = wishListPage
				.gotoWishList()
				.deleteFromWishList(iPhone)
				.deleteFromWishList(macBook);
		
		Assert.assertTrue(cleanUpWishList
				.checkEmptyWishList());
		
		AccountLogoutPage logout= cleanUpWishList
				.gotoLogout();
		
		Assert.assertTrue(logout.getAccountLogoutLabel().isDisplayed());
		
        logger.info("DONE TEST: addToWishListFewProducts");
	}
	
}
