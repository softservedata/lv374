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

public class TotalPriceTableTest extends TestRunnerVoluikevych {

    public static final Logger logger = LoggerFactory.getLogger(TotalPriceTableTest.class);

    private static final boolean withTax = false;
    private static final String euroSymbol = "€";

    @DataProvider
    public Object[][] totalPrice() {
        return new Object[][] {{
                Currencies.EURO,
                Currencies.US_DOLLAR,
                withTax
        }};
    }

    /**
     * This test checks if total price of all products convert correctly to Euro at Shopping Cart Page
     * Used technique: Use case testing
     * @param euro
     * @param usd
     * @param withTax
     */
    @Description("Test Description: class TotalPriceTableTest, totalPriceTest")
    @Test(dataProvider = "totalPrice")
    public void totalPriceTest(Currencies euro, Currencies usd, boolean withTax){
        logger.info("totalPriceTest START");
        ShoppingCartPage shoppingCartPage = loadApplication()
                .gotoShoppingCart();
        BigDecimal totalUSD = shoppingCartPage.getTableTotalByCurrency(usd);
        BigDecimal totalEuro = shoppingCartPage.gotoShoppingCart().getTableTotalByCurrency(euro);
        Assert.assertEquals(totalEuro, PriceUtils.getExpectedEURO(totalUSD,withTax));
        logger.info("totalPriceTest DONE");
    }

    @DataProvider
    public Object[][] euroSymbolTotalPrice(){
        return new Object[][] {{
                ProductRepository.getIPhone(),
                ProductRepository.getMacBook(),
                Currencies.EURO,
                euroSymbol
        }};
    }

    /**
     * This test checks if currency symbol at total price column change correctly to Euro at Shopping Cart Page
     * Used technique: Use case testing
     * @param iphone
     * @param macBook
     * @param currency
     * @param currencySymbol
     */
    @Description("Test Description: class TotalPriceTableTest, checkTableEuroSymbol")
    @Test(dataProvider = "euroSymbolTotalPrice")
    public void checkTableEuroSymbol(Product iphone, Product macBook, Currencies currency, String currencySymbol){
        logger.info("checkTableEuroSymbol START");
        String symbol = loadApplication()
                .addToShoppingCart(iphone)
                .refresh()
                .addToShoppingCart(macBook)
                .gotoShoppingCart()
                .chooseCurrency(currency)
                .getTotalPriceTableComponent()
                .getTableTotalSymbol();
        Assert.assertEquals(symbol,currencySymbol,"Currency is not equals");
        logger.info("checkTableEuroSymbol DONE");
    }
}
