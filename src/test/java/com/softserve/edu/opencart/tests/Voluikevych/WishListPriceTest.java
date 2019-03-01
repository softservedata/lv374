package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.shop.HomePage;
import com.softserve.edu.opencart.tools.PriceUtils;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class WishListPriceTest extends TestRunnerVoluikevych{

    public static final Logger logger = LoggerFactory.getLogger(WishListPriceTest.class);

    private static final boolean withTax = false;

    @DataProvider
    public Object[][] wishListPriceEuro(){
        return new Object[][]{{
                UserRepository.getValid(),
                ProductRepository.getMacBook(),
                Currencies.EURO,
                withTax
        }};
    }

    /**
     * This test checks if product price convert correctly to Euro at Wish List Page
     * @param validUser
     * @param macBook
     * @param currency
     * @param withTax
     */
    @Description("Test Description: class WishListPriceTest, wishListPriceEuroTest")
    @Test(dataProvider = "wishListPriceEuro")
    public void wishListPriceEuroTest(IUser validUser, Product macBook, Currencies currency, boolean withTax){
        logger.info("wishListPriceEuroTest START");
        BigDecimal actual = loadApplication()
                .gotoLogin()
                .successLogin(validUser)
                .gotoHomePage()
                .getProductComponentsContainer()
                .addToWishList(macBook)
                .gotoWishList()
                .getWishListPriceByCurrency(currency, macBook);
        Assert.assertEquals(actual, PriceUtils.getExpectedEURO(macBook.getPriceDollar(),withTax));
        logger.info("wishListPriceEuroTest DONE");
    }
}
