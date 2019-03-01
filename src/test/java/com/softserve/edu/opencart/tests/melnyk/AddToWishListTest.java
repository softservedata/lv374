package com.softserve.edu.opencart.tests.melnyk;

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

	@DataProvider
	public Object[][] oneProductDataProvider() {
		return new Object[][] { { UserRepository.getValid() ,
				ProductRepository.getIPhone()
		} };
	}

	@Test(dataProvider = "oneProductDataProvider")
	public void addToWishListOneProduct(IUser validUser, Product validProduct) {
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
	}

	@DataProvider
	public Object[][] fewProductDataProvider() {
		return new Object[][] { { UserRepository.getValid() ,
				ProductRepository.getIPhone(),
				ProductRepository.getMacBook()
		} };
	}
	
	@Test(dataProvider = "fewProductDataProvider")
	public void addToWishListFewProducts(IUser validUser, Product iPhone, Product macBook) {
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
	}
	
	
//	@Test
//	public void checkScreen() throws FindFailed {
//		Screen s = new Screen();
//		
//		s.find("logo.png");
//		s.click("logo.png");
//	}
}
