package com.softserve.edu.opencart.tests.melnyk;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.WishListPage;

public class DeleteFromWishListTest extends TestRunner{
	
	@DataProvider
	public Object[][] dataProvider() {
		return new Object[][] { { UserRepository.getValid() ,
			 ProductRepository.getIPhone()
			 } };
	}
	
	@Test(dataProvider = "dataProvider")
	public void checkDeleteFromWishList(IUser validUser, Product validProduct) {
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
				Assert.assertFalse(wishListPage
				.getWishListContainer()
				.getWishListComponents()
				.contains(validProduct.getName()));
		}
	
}
