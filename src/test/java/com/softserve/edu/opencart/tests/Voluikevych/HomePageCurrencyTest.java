package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.shop.HomePage;
import com.softserve.edu.opencart.tools.PriceUtils;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class HomePageCurrencyTest extends TestRunnerVoluikevych {

    public static final Logger logger = LoggerFactory.getLogger(HomePageCurrencyTest.class);

    private static final boolean withTax = true;
    private static final String euroSymbol = "€";
    private static final String poundSymbol = "£";

    @DataProvider
    public Object[][] homePageEuro() {
        return new Object[][] {{
                ProductRepository.getIPhone(),
                Currencies.EURO,
                euroSymbol,
                withTax
        }};
    }

    /**
     * This test checks if currency symbol change correctly to chosen currency
     * Used technique: Use case testing
     * @param product
     * @param currency
     * @param currencySymbol
     * @param withTax
     */
    @Description("Test Description: class HomePageCurrencyTest, changeCurrencyToEURO")
    @Test(dataProvider = "homePageEuro")
    public void changeCurrencyToEURO(Product product, Currencies currency, String currencySymbol,boolean withTax){
        logger.info("changeCurrencyToEURO START");
        String actualCurrency = loadApplication()
                .chooseCurrency(currency)
                .getHomePageCurrencySymbol(product);
        Assert.assertEquals(actualCurrency,currencySymbol, "Currency not equals");
        logger.info("changeCurrencyToEURO DONE");
    }

    @DataProvider
    public Object[][] homePagePound() {
        return new Object[][] {{
                ProductRepository.getIPhone(),
                Currencies.POUND_STERLING,
                poundSymbol,
                withTax
        }};
    }

    /**
     * This test checks if currency symbol change correctly to chosen currency
     * Used technique: Use case testing
     * @param product
     * @param currency
     * @param currencySymbol
     * @param withTax
     */
    @Description("Test Description: class HomePageCurrencyTest, changeCurrencyToPound")
    @Test(dataProvider = "homePagePound")
    public void changeCurrencyToPound(Product product, Currencies currency, String currencySymbol,boolean withTax){
        logger.info("changeCurrencyToPound START");
        String actualCurrency = loadApplication()
                .chooseCurrency(currency)
                .getHomePageCurrencySymbol(product);
        Assert.assertEquals(actualCurrency,currencySymbol, "Currency not equals");
        logger.info("changeCurrencyToPound DONE");
    }

    /**
     * This test checks if product price convert correctly to Euro at HomePage
     * Used technique: Use case testing
     * @param iphone
     * @param currency
     * @param str
     * @param withTax
     */
    @Description("Test Description: class HomePageCurrencyTest, homePageConvertPriceToEuro")
    @Test(dataProvider = "homePageEuro")
    public void homePageConvertPriceToEuro(Product iphone, Currencies currency, String str, boolean withTax){
        logger.info("homePageConvertPriceToEuro START");
        BigDecimal euro = loadApplication()
                .chooseCurrency(currency)
                .getProductComponentsContainer()
                .getProductComponentPriceByProduct(iphone);
        Assert.assertEquals(euro, PriceUtils.getExpectedEURO(iphone.getPriceDollar(), withTax));
        logger.info("homePageConvertPriceToEuro DONE");
    }

    /**
     * This test checks if product price convert correctly to Pound Sterling at HomePage
     * Used technique: Use case testing
     * @param iphone
     * @param currency
     * @param str
     * @param withTax
     */
    @Description("Test Description: class HomePageCurrencyTest, homePageConvertPriceToPound")
    @Test(dataProvider = "homePagePound")
    public void homePageConvertPriceToPound(Product iphone, Currencies currency, String str, boolean withTax){
        logger.info("homePageConvertPriceToPound START");
        BigDecimal pound = loadApplication()
                .chooseCurrency(currency)
                .getProductComponentsContainer()
                .getProductComponentPriceByProduct(iphone);
        Assert.assertEquals(pound, PriceUtils.getExpectedPOUND(iphone.getPriceDollar(),withTax));
        logger.info("homePageConvertPriceToPound DONE");
    }

}
