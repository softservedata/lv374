package com.softserve.edu.opencart.tests.melnyk;

import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.WishListComponent;
import com.softserve.edu.opencart.pages.account.WishListPage;
import com.softserve.edu.opencart.pages.shop.CartProductComponent;
import com.softserve.edu.opencart.pages.shop.CartProductContainer;
import com.softserve.edu.opencart.pages.shop.ShoppingCartPage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class AddToCartTest extends TestRunner{

	@DataProvider
	public Object[][] dataProvider() {
		return new Object[][] { { UserRepository.getValid() ,
			 ProductRepository.getIPhone()
			 } };
	}
	
	@Test(dataProvider = "dataProvider")
	public void checkAddToCart(IUser validUser, Product validProduct) {
		ShoppingCartPage cartPage = loadApplication()
				.gotoLogin()
				.successLogin(validUser)
				.gotoHomePage()
	 			.successfulSearch(validProduct)
				.getSearchResultComponent()
				.getProductComponentsContainer()
				.addToWishList(validProduct.getName())
				.gotoWishList()
				.gotoShoppingCart();
		Assert.assertTrue(cartPage
				.getShoppingCartProductsContainer()
				.getNameByProduct(validProduct)
				.contains(validProduct.getName()));
		}
}
