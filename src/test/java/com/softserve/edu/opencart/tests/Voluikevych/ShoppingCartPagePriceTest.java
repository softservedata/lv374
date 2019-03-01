package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.shop.HomePage;
import com.softserve.edu.opencart.pages.shop.ShoppingCartPage;
import com.softserve.edu.opencart.tools.PriceUtils;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class ShoppingCartPagePriceTest extends TestRunnerVoluikevych {

    public static final Logger logger = LoggerFactory.getLogger(ShoppingCartPagePriceTest.class);

    private static final boolean withTax = true;

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {{
                ProductRepository.getIPhone(),
                ProductRepository.getMacBook(),
                Currencies.EURO,
                withTax
        }};
    }

    /**
     * This test checks if product price convert correctly to Euro at Shopping Cart Page
     * Used technique: Use case testing
     * @param iphone
     * @param macBook
     * @param currency
     * @param withTax
     */
    @Description("Test Description: class ShoppingCartPagePriceTest, convertUSDToEURO")
    @Test(dataProvider = "dataProvider")
    public void convertUSDToEURO(Product iphone, Product macBook, Currencies currency, boolean withTax) {
        logger.info("convertUSDToEURO START");
        BigDecimal euro = loadApplication()
                .addToShoppingCart(iphone)
                .refresh()
                .addToShoppingCart(macBook)
                .gotoShoppingCart()
                .getTotalProductPriceByCurrency(currency, macBook);
        Assert.assertEquals(euro, PriceUtils.getExpectedEURO(macBook.getPriceDollar(), withTax));
        logger.info("convertUSDToEURO DONE");
    }

}
