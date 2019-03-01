package com.softserve.edu.opencart.tests.melnyk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.WishListPage;

public class RightMenuWishListTest extends TestRunner{
	
    public static final Logger logger = LoggerFactory.getLogger(AddToWishListTest.class);

	/**
	 * Provide valid user to log in.
	 */
	@DataProvider
	public Object[][] wishListDataProvider() {
		return new Object[][] { { UserRepository.getValid()} };
	}

	/**
	 * Positive test
	 * Used technique: State transition
	 * Check if wish list from right menu unit redirect to wish list
	 * 
	 * @param validUser user that exist in database
	 */
	@Test(dataProvider = "wishListDataProvider")
	public void rightMenuWishListTest(IUser validUser) {
		
        logger.info("START TEST: rightMenuWishListTest");

		WishListPage rightMenuWishList= loadApplication()
				.gotoLogin()
				.successLogin(validUser)
				.gotoWishListPage();
		
		Assert.assertTrue(rightMenuWishList
				.checkEmptyWishList());
		
        logger.info("DONE TEST: rightMenuWishListTest");
	}
}
