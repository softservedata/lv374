package com.softserve.edu.opencart.tests.melnyk;

import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.account.WishListPage;
import com.softserve.edu.opencart.pages.shop.ShoppingCartPage;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

@Epic("Regression Test")
@Feature("AddToCartTest")
public class AddToCartTest extends TestRunner{

    public static final Logger logger = LoggerFactory.getLogger(AddToCartTest.class);
	
    /**
     * Save image that will be copied and shown in the report as a attachment
     * 
     * @return byte array containing the bytes read from the file
     */
	@Attachment(value = "{0}", type = "image/png")
	public byte[] saveImageAttach(String attachName) {
		byte[] result = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			result = Files.readAllBytes(scrFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Make screenshot of page
	 */
	@Step("ScreenShot of Cart STEP")
	private void takeScreenShot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/home/milnik/Pictures/cartscreenshot.png"));
	}
	
	/**
	 * Provide valid user to log in and product that will be tested.
	 */
	@DataProvider
	public Object[][] validUserAndProductProvider() {
		return new Object[][] { { UserRepository.getValid() ,
			 ProductRepository.getIPhone()
			 } };
	}
	
	/**
	 * Positive test
	 * Used technique: State transition
	 * Check if add to cart button added product to cart from wish list
	 * 
	 * @param validUser user that exist in database
	 * @param validProduct product that will be tested
	 */
	@Description("Test Description: This test check if product added to cart from wishlist")
	@Severity(SeverityLevel.NORMAL)
	@Story("click AddToCart and check if product added to Cart")
	@Test(dataProvider = "validUserAndProductProvider")
	public void checkAddToCart(IUser validUser, Product validProduct) throws IOException {
		
        logger.info("START TEST: checkAddToCart");

		ShoppingCartPage cartPage = loadApplication()
				.gotoLogin()
				.successLogin(validUser)
				.gotoHomePage()
	 			.successfulSearch(validProduct)
				.getSearchResultComponent()
				.getProductComponentsContainer()
				.addToWishList(validProduct)
				.gotoWishList()
				.addToCart(validProduct)
				.gotoShoppingCart();
		
		takeScreenShot();
        saveImageAttach("devextreme-reactive");
        
		Assert.assertTrue(cartPage
				.getShoppingCartProductsContainer()
				.getNameByProduct(validProduct)
				.contains(validProduct.getName()));
		
		WishListPage cleanUpWishList = cartPage
				.gotoWishList()
				.deleteFromWishList(validProduct);
		
		Assert.assertTrue(cleanUpWishList
				.checkEmptyWishList());
		
        logger.info("DONE TEST: checkAddToCart");
	}
	
	
}
