package com.softserve.edu.opencart.melnyk;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.WishListPage;
import com.softserve.edu.opencart.pages.shop.HomePage;

public class AddToWishListTest extends TestRunner {

	@DataProvider
	public Object[][] dataProvider() {
		return new Object[][] { { UserRepository.getValid() ,
			 ProductRepository.getIPhone()
			 } };
	}

	//@Test(dataProvider = "dataProvider")
	public void checkAddToCart(IUser validUser, Product validProduct) {
		WishListPage wishListPage = loadApplication()
				.gotoLogin()
				.successLogin(validUser)
				.gotoHomePage()
				.successfulSearch(validProduct)
				.getSearchResultComponent()
				.getProductComponentsContainer()
				.addToWishList(validProduct.getName())
				.gotoWishList();
		Assert.assertTrue(wishListPage
				.getWishListContainer()
				.getWishListNameByProduct(validProduct)
				.contains(validProduct.getName()));
	}
	
	@Test
	public void checkScreen() throws FindFailed {
		Screen s = new Screen();
		s.find("logo.png");
		s.click("logo.png");
	}
}
